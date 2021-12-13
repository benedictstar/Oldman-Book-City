package com.hh.repository.Impl;

import com.hh.entity.checkHistory;
import com.hh.repository.CheckRepository;
import com.hh.utils.JDBCTools;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChechRepositoryImpl implements CheckRepository {
    @Override
    public void addCheckHistory(String tel, int id, Timestamp date) {
        //获取连接
        Connection connection= JDBCTools.getConnection();
        String sql="insert into history values(0,?,?,?)";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            //插入记录
            statement=connection.prepareStatement(sql);
            statement.setString(1,tel);
            statement.setInt(2,id);
            statement.setTimestamp(3,date);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement,resultSet);
        }
    }

    @Override
    public List<checkHistory> getCheckHistory(String tel) {
        Connection connection=JDBCTools.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String sql="select history.id,usertel,name,time from commodity,history where history.commodity_id = commodity.id and usertel=? ";
        List<checkHistory> h=new ArrayList<checkHistory>();
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,tel);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                checkHistory ch=new checkHistory(resultSet.getString(2),resultSet.getString(3),resultSet.getTimestamp(4),resultSet.getInt(1));
                h.add(ch);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        return h;
    }
}
