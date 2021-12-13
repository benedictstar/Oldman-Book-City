package com.hh.repository.Impl;

import com.hh.entity.User;
import com.hh.repository.RegisterRepository;
import com.hh.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterReponsitoryImpl implements RegisterRepository {
    //返回错误码，0是无错，1是用户名错，2是电话重复，3是邮箱重复
    @Override
    public Integer register(String name, String password, String tel, String email) {
//        连接、sql语句、statement等的准备工作
        Connection connection= JDBCTools.getConnection();
        String isname="select * from user where name = ?";
        String istel="select * from user where tel = ?";
        String isemail="select * from user where email = ?";
        String insert="insert into user(name,password,tel,email) values(?,?,?,?)";
        PreparedStatement statement1=null;
        PreparedStatement statement2=null;
        PreparedStatement statement3=null;
        PreparedStatement statement4=null;
        ResultSet resultSet=null;
        int flag=0;
        try {
            //查看有无一致的用户名，有则返回1
            statement1=connection.prepareStatement(isname);
            statement1.setString(1,name);
            resultSet=statement1.executeQuery();
            if(resultSet.next()) {
                flag=1;
            }
            else{
                //查看有无一致的电话，有则返回2
                resultSet=null;
                statement2=connection.prepareStatement(istel);
                statement2.setString(1,tel);
                resultSet=statement2.executeQuery();
                if(resultSet.next()){
                    flag=2;
                }else{
                    //查看有无一致的邮箱，有则返回3
                    resultSet=null;
                    statement3=connection.prepareStatement(isemail);
                    statement3.setString(1,email);
                    resultSet=statement3.executeQuery();
                    if(resultSet.next()){
                        flag=3;
                    }
                    else{
                        //保证上述信息合法后，插入本条数据，返回0
                        resultSet=null;
                        statement4=connection.prepareStatement(insert);
                        statement4.setString(1,name);
                        statement4.setString(2,password);
                        statement4.setString(3,tel);
                        statement4.setString(4,email);
                        statement4.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放连接等内容
            JDBCTools.release(connection,statement1,resultSet);
            JDBCTools.releaseStatement(statement2);
            JDBCTools.releaseStatement(statement3);
            JDBCTools.releaseStatement(statement4);
            return flag;
        }


    }
}
