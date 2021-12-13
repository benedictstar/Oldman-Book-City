package com.hh.service;

import com.hh.entity.ShoppingList;

public interface ShoppingService {
    public ShoppingList searchShopping(String tel);
    public void addShopping(String tel,int id,int addnum);
    public void reduceShopping(String tel,int id,int reducenum);
    public void deleteShopping(String tel,int id);
    public int getShopping(String tel,int id);
}
