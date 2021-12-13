package com.hh.repository;

import com.hh.entity.buyHistory;

import java.sql.Timestamp;
import java.util.List;

public interface BuyRepository {
    public void addBuyHistory(String tel, int id, int buynum, Timestamp date);
    public List<buyHistory> getBuyHistory();
    public List<buyHistory> getBuyHistory(String tel);
}
