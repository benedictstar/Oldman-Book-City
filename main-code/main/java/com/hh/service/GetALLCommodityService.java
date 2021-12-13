package com.hh.service;

import com.hh.entity.Commodity;
import com.hh.entity.TotalCommodity;

public interface GetALLCommodityService {
    public TotalCommodity getAllCommodity();
    public Commodity searchCommodity(int id);
    public void changeCommodity(Commodity commodity);
    public void deleteCommodity(int id);
    public boolean addCommodity(Commodity commodity);
    public boolean reduceCommodity(int id,int reducenum);
    public TotalCommodity searchCommodityByName(String name);
}
