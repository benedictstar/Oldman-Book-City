package com.hh.repository.Impl;

import com.hh.entity.SuperUser;
import com.hh.entity.User;
import com.hh.repository.UserRepository;
import com.hh.utils.JDBCTools;

import java.sql.*;

public class UserRepositoryImpl implements UserRepository {
    //成功返回用户对象的全部信息，失败返回空对象
    @Override
    public User login(String name, String password) {
        //准备工作，获取连接，撰写sql语句，新建statement等对象
        Connection connection= JDBCTools.getConnection();
        String sql="select * from user where name = ? and password = ?";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        User user=null;
        try {
            //执行sql语句
            statement=connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,password);
            resultSet=statement.executeQuery();
//            当查询结果存在时获得查询结果
            if(resultSet.next()){
                user=new User(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        return user;

    }

    @Override
    public SuperUser superLogin(String name, String password) {
        Connection connection= JDBCTools.getConnection();
        String sql="select * from superuser where name = ? and password = ?";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        SuperUser user=null;
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,password);
            resultSet=statement.executeQuery();
            if(resultSet.next()){
                user=new SuperUser(resultSet.getString(2),resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        return user;
    }
}
