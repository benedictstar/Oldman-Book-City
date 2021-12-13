package com.hh.repository;

import com.hh.entity.Commodity;

import java.util.List;

public interface CommodityRepository {
    public List<Commodity> getAllCommodity();
    public Commodity searchCommodity(int id);
    public void changeCommodity(Commodity commodity);
    public void deleteCommodity(int id);
    public boolean addCommodity(Commodity commodity);
    public boolean reduceCommodity(int id,int reducenum);
    public List<Commodity> searchCommodityByName(String name);
}
