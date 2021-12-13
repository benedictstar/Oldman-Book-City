package com.hh.repository;

import com.hh.entity.Commodity;

import java.util.List;

public interface ShoppingRepository {
    public List<Commodity> searchShoppinglist(String tel);
    public void addShoppingnum(String tel,int id,int addnum);
    public void reduceShoppingnum(String tel,int id,int reducenum);
    public void deleteShoppingnum(String tel,int id);
    public int getShoppingnum(String tel,int id);
}
