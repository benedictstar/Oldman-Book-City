package com.hh.service;

import com.hh.entity.TotalBuyHistory;
import com.hh.entity.buyHistory;

import java.util.Date;
import java.util.List;

public interface BuyService {
    public void addBuyHistory(String tel, int id, int buynum, Date date);
    public TotalBuyHistory getBuyHistory();
    public TotalBuyHistory getBuyHistory(String tel);
}
