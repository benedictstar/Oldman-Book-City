package com.hh.service.Impl;

import com.hh.entity.TotalBuyHistory;
import com.hh.entity.buyHistory;
import com.hh.repository.BuyRepository;
import com.hh.repository.Impl.BuyRepositoryImpl;
import com.hh.service.BuyService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class BuyServiceImpl implements BuyService {
    private BuyRepository buyRepository=new BuyRepositoryImpl();
    @Override
    public void addBuyHistory(String tel, int id, int buynum, Date date){
        Timestamp timestamp=new Timestamp(date.getTime());
        buyRepository.addBuyHistory(tel,id,buynum,timestamp);
    }

    @Override
    public TotalBuyHistory getBuyHistory() {
        return new TotalBuyHistory(buyRepository.getBuyHistory());
    }

    @Override
    public TotalBuyHistory getBuyHistory(String tel) {
        return new TotalBuyHistory(buyRepository.getBuyHistory(tel));
    }
}
