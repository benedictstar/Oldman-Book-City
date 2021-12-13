package com.hh.repository.Impl;

import com.hh.entity.Commodity;
import com.hh.repository.ShoppingRepository;
import com.hh.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingRepositoryImpl implements ShoppingRepository {
    @Override
    public List<Commodity> searchShoppinglist(String tel) {
        Connection connection= JDBCTools.getConnection();
        PreparedStatement statement1=null;
        PreparedStatement statement2=null;
        ResultSet resultSet1=null;
        ResultSet resultSet2=null;
        String sql1="select * from shoppinglist where usertel = ?";
        String sql2="select * from commodity where id = ?";
        List<Commodity> commodities=new ArrayList<Commodity>();
        try {
            statement1=connection.prepareStatement(sql1);
            statement1.setString(1,tel);
            resultSet1=statement1.executeQuery();
            List<Integer> c=new ArrayList<Integer>();
            List<Integer> num=new ArrayList<Integer>();
            while(resultSet1.next()) {
                c.add(resultSet1.getInt(3));
                num.add(resultSet1.getInt(4));
            }
//            System.out.println("hhh");
//            System.out.println(num.get(0));
            statement2=connection.prepareStatement(sql2);
            for(int i=0;i<c.size();i++){
                statement2.setString(1,c.get(i).toString());
                resultSet2=statement2.executeQuery();
                if(resultSet2.next()) {
                    Commodity commodity = new Commodity(resultSet2.getInt(1), resultSet2.getString(2), resultSet2.getString(4), resultSet2.getString(5), resultSet2.getDouble(3), resultSet2.getString(7), resultSet2.getString(6), num.get(i), resultSet2.getInt(8));
                    commodities.add(commodity);
                }
                resultSet2=null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement1,resultSet1);
            JDBCTools.release(connection,statement2,resultSet2);
        }
        return commodities;
    }

    @Override
    public void addShoppingnum(String tel,int id, int addnum) {
        //准备工作
        Connection connection=JDBCTools.getConnection();
        String sql1="update shoppinglist set shoppingnum = ? where usertel=? and commodity_id=?";
        String sql2="insert into shoppinglist values (0,?,?,?)";
        String sql3="select shoppingnum from shoppinglist where usertel=? and commodity_id=?";
        PreparedStatement statement=null;
        PreparedStatement statement2=null;
        ResultSet resultSet=null;
        int num=0;
        try {
            //查询是否有这条记录
            statement2=connection.prepareStatement(sql3);
            statement2.setString(1,tel);
            statement2.setString(2,Integer.toString(id));
            resultSet=statement2.executeQuery();
            if(resultSet.next()){
               num=resultSet.getInt(1);
            }
            else{
                num=0;
            }
            if(num==0){
                //进行插入操作
                statement=connection.prepareStatement(sql2);
                statement.setString(1,tel);
                statement.setString(2,Integer.toString(id));
                statement.setString(3,Integer.toString(num+addnum));
            }
            else {
                //进行新增操作
                statement = connection.prepareStatement(sql1);
                statement.setString(1,Integer.toString(num+addnum));
                statement.setString(2,tel);
                statement.setString(3,Integer.toString(id));
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            //释放连接
            JDBCTools.release(connection,statement,resultSet);
            JDBCTools.releaseStatement(statement2);
        }
    }

    @Override
    public void reduceShoppingnum(String tel, int id, int reducenum) {
        //准备工作
        Connection connection=JDBCTools.getConnection();
        String sql1="update shoppinglist set shoppingnum = ? where usertel=? and commodity_id=?";
        String sql2="select shoppingnum from shoppinglist where usertel=? and commodity_id=?";
        PreparedStatement statement=null;
        PreparedStatement statement2=null;
        ResultSet resultSet=null;
        int num=0;
        try {
            //减少商品，当购物车内商品减为0时就删除这天记录
            statement2=connection.prepareStatement(sql2);
            statement2.setString(1,tel);
            statement2.setString(2,Integer.toString(id));
            resultSet=statement2.executeQuery();
            if(resultSet.next()){
                num=resultSet.getInt(1);
            }
            if(num-reducenum<0){
                return;
            }
            if(num-reducenum==0){
                deleteShoppingnum(tel,id);
            }
            else {
                statement = connection.prepareStatement(sql1);
                statement.setString(1,Integer.toString(num-reducenum));
                statement.setString(2,tel);
                statement.setString(3,Integer.toString(id));
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCTools.release(connection,statement,resultSet);
            JDBCTools.releaseStatement(statement2);
        }
    }

    @Override
    public void deleteShoppingnum(String tel, int id) {
        //准备工作，主要是连接
        Connection connection=JDBCTools.getConnection();
        String sql="delete from shoppinglist where usertel=? and commodity_id=?";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            //删除对应记录
            statement=connection.prepareStatement(sql);
            statement.setString(1,tel);
            statement.setString(2,Integer.toString(id));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCTools.release(connection,statement,resultSet);
        }
    }

    @Override
    public int getShoppingnum(String tel, int id) {
        Connection connection=JDBCTools.getConnection();
        String sql="select shoppingnum from shoppinglist where usertel=? and commodity_id=?";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        int num=0;
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,tel);
            statement.setInt(2,id);
            resultSet=statement.executeQuery();
            if(resultSet.next()){
                num=resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        return num;
    }
}
