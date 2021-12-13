package com.hh.repository.Impl;

import com.hh.entity.Commodity;
import com.hh.repository.CommodityRepository;
import com.hh.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommodityRepositoryImpl implements CommodityRepository {
    @Override
    public List<Commodity> getAllCommodity() {
        //准备工作
        Connection connection= JDBCTools.getConnection();
        String sql="select * from commodity";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Commodity> commodities=new ArrayList<Commodity>();
        try {
            //执行查询，得到商品结果列表
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Commodity com=new Commodity(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(4),resultSet.getString(5),resultSet.getDouble(3),resultSet.getString(7),resultSet.getString(6),0,resultSet.getInt(8));
                commodities.add(com);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return commodities;

    }

    @Override
    public Commodity searchCommodity(int id) {
        //准备工作
        Connection connection= JDBCTools.getConnection();
        String sql="select * from commodity where id =  ?";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        Commodity commodities=null;
        try {
            //连接数据库，得到结果
            statement=connection.prepareStatement(sql);
            statement.setString(1,Integer.toString(id));
            resultSet=statement.executeQuery();
            if (resultSet.next()){
                commodities=new Commodity(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(4),resultSet.getString(5),resultSet.getDouble(3),resultSet.getString(7),resultSet.getString(6),0,resultSet.getInt(8));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        //返回搜素结果
        return commodities;
    }

    @Override
    public List<Commodity> searchCommodityByName(String name) {
//        准备工作
        Connection connection= JDBCTools.getConnection();
        String sql="select * from commodity where name =  ?";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<Commodity> commodities=new ArrayList<Commodity>();
        try {
//            得到搜索商品结果列表
            statement=connection.prepareStatement(sql);
            statement.setString(1,name);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Commodity com=new Commodity(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(4),resultSet.getString(5),resultSet.getDouble(3),resultSet.getString(7),resultSet.getString(6),0,resultSet.getInt(8));
                commodities.add(com);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        return commodities;
    }

    @Override
    public void changeCommodity(Commodity commodity) {
        Connection connection=JDBCTools.getConnection();
        ResultSet resultSet=null;
        PreparedStatement statement=null;
        String sql="update commodity set name=?,price=?,detail=?,author=?,face=?,url=?,num=? where id=?";
        try {
            //按照输入的信息修改
            statement=connection.prepareStatement(sql);
            statement.setString(1,commodity.getCommodityname());
            statement.setDouble(2,commodity.getPrice());
            statement.setString(3,commodity.getDetail());
            statement.setString(4,commodity.getAuthor());
            statement.setString(5,commodity.getFace());
            statement.setString(6,commodity.getUrl());
            statement.setInt(7,commodity.getTotalnum());
            statement.setInt(8,commodity.getCom_id());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement,resultSet);
        }

    }

    @Override
    public void deleteCommodity(int id) {
        Connection connection=JDBCTools.getConnection();
        ResultSet resultSet=null;
        PreparedStatement statement=null;
        String sql="delete from commodity where id=?";
        try {
            //直接删除
            statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement,resultSet);
        }

    }

    @Override
    public boolean addCommodity(Commodity commodity) {
        boolean is=true;
        Connection connection=JDBCTools.getConnection();
        ResultSet resultSet=null;
        PreparedStatement statement=null;
        PreparedStatement statement2=null;
        String sql1="select * from commodity where name=?";
        String sql2="insert into commodity values(0,?,?,?,?,?,?,?)";
        try {
            statement=connection.prepareStatement(sql1);
            statement.setString(1,commodity.getCommodityname());
            resultSet=statement.executeQuery();
            if(resultSet.next()){
                is=false;
            }
            else{
                is=true;
                statement2=connection.prepareStatement(sql2);
                statement2.setString(1,commodity.getCommodityname());
                statement2.setDouble(2,commodity.getPrice());
                statement2.setString(3,commodity.getDetail());
                statement2.setString(4,commodity.getAuthor());
                statement2.setString(5,commodity.getFace());
                statement2.setString(6,commodity.getUrl());
                statement2.setInt(7,commodity.getTotalnum());
                statement2.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement,resultSet);
            JDBCTools.releaseStatement(statement2);
        }
        return is;
    }

    @Override
    public boolean reduceCommodity(int id, int reducenum) {
        //获取连接等操作
        Connection connection=JDBCTools.getConnection();
        ResultSet resultSet=null;
        PreparedStatement statement=null;
        PreparedStatement statement2=null;
        String sql1="select num from commodity where id=?";
        String sql2="update commodity set num=? where id=?";
        int finalnum=0;
        boolean is=true;
        //当数据库中的数量不足以完成整个购买操作时，返回false并且不操作，否则更新数据库
        try {
            statement=connection.prepareStatement(sql1);
            statement.setInt(1,id);
            resultSet=statement.executeQuery();
            if(resultSet.next()){
                int c=resultSet.getInt(1);
                if(c-reducenum>finalnum){
                    finalnum=c-reducenum;
                    statement2=connection.prepareStatement(sql2);
                    statement2.setInt(1,finalnum);
                    statement2.setInt(2,id);
                    statement2.executeUpdate();
                    is=true;
                }
                else{
                    if(c-reducenum==0){
                        deleteCommodity(id);
                        is=true;
                    }
                    else {
                        is = false;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放
            JDBCTools.release(connection,statement,resultSet);
            JDBCTools.releaseStatement(statement2);
        }
        return is;
    }
}
