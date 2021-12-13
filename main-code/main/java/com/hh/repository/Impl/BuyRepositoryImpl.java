package com.hh.repository.Impl;

import com.hh.entity.buyHistory;
import com.hh.repository.BuyRepository;
import com.hh.utils.JDBCTools;
import com.mysql.cj.jdbc.JdbcConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class BuyRepositoryImpl implements BuyRepository {
    @Override
    public void addBuyHistory(String tel, int id, int buynum, Timestamp date) {
        Connection connection= JDBCTools.getConnection();
        String sql="insert into buy values(0,?,?,?,?)";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,tel);
            statement.setInt(2,id);
            statement.setInt(3,buynum);
            statement.setTimestamp(4,date);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement,resultSet);
        }
    }

    @Override
    public List<buyHistory> getBuyHistory() {
        Connection connection=JDBCTools.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String sql1="select buy.id,usertel,commodity.name,commodity.price,buy.buynum,buy.time from buy,commodity where buy.commodity_id = commodity.id";
        List<buyHistory> buy=new ArrayList<buyHistory>();
        try {
            //得到所有的购买历史
            statement=connection.prepareStatement(sql1);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                buyHistory b=new buyHistory(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4),resultSet.getInt(5),resultSet.getTimestamp(6));
                buy.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        return buy;
    }

    @Override
    public List<buyHistory> getBuyHistory(String tel) {
        Connection connection=JDBCTools.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String sql1="select buy.id,usertel,commodity.name,commodity.price,buy.buynum,buy.time from buy,commodity where buy.commodity_id = commodity.id and usertel=?";
        List<buyHistory> buy=new ArrayList<buyHistory>();
        try {
            statement=connection.prepareStatement(sql1);
            statement.setString(1,tel);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                buyHistory b=new buyHistory(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4),resultSet.getInt(5),resultSet.getTimestamp(6));
                buy.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        return buy;
    }
}
