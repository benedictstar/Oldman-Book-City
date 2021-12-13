package com.hh.service.Impl;

import com.hh.entity.ShoppingList;
import com.hh.repository.Impl.ShoppingRepositoryImpl;
import com.hh.repository.ShoppingRepository;
import com.hh.service.ShoppingService;

public class ShoppingServiceImpl implements ShoppingService {
    private ShoppingRepository shoppingRepository= new ShoppingRepositoryImpl();
    @Override
    public ShoppingList searchShopping(String tel) {
        ShoppingList shoppingList=new ShoppingList(shoppingRepository.searchShoppinglist(tel));
        return shoppingList;
    }

    @Override
    public void addShopping(String tel,int id, int addnum) {
        shoppingRepository.addShoppingnum(tel,id,addnum);
    }

    @Override
    public void reduceShopping(String tel, int id, int reducenum) {
        shoppingRepository.reduceShoppingnum(tel,id,reducenum);
    }

    @Override
    public void deleteShopping(String tel, int id) {
        shoppingRepository.deleteShoppingnum(tel,id);
    }

    @Override
    public int getShopping(String tel, int id) {
        return shoppingRepository.getShoppingnum(tel,id);
    }
}
