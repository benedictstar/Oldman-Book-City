package com.hh.service.Impl;

import com.hh.entity.Commodity;
import com.hh.entity.TotalCommodity;
import com.hh.repository.CommodityRepository;
import com.hh.repository.Impl.CommodityRepositoryImpl;
import com.hh.service.GetALLCommodityService;

public class GetAllCommodityServiceImpl implements GetALLCommodityService {
    private CommodityRepository commodityRepository=new CommodityRepositoryImpl();
    @Override
    public TotalCommodity getAllCommodity() {
        TotalCommodity totalCommodity=new TotalCommodity(commodityRepository.getAllCommodity());
        return totalCommodity;
    }

    @Override
    public Commodity searchCommodity(int id) {
        return commodityRepository.searchCommodity(id);
    }

    @Override
    public TotalCommodity searchCommodityByName(String name) {
        TotalCommodity totalCommodity=new TotalCommodity(commodityRepository.searchCommodityByName(name));
        return totalCommodity;
    }

    @Override
    public void changeCommodity(Commodity commodity) {
        commodityRepository.changeCommodity(commodity);
    }

    @Override
    public void deleteCommodity(int id) {
        commodityRepository.deleteCommodity(id);
    }

    @Override
    public boolean addCommodity(Commodity commodity) {
        return commodityRepository.addCommodity(commodity);
    }

    @Override
    public boolean reduceCommodity(int id, int reducenum) {
        return commodityRepository.reduceCommodity(id,reducenum);
    }
}
