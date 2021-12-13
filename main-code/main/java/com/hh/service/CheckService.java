package com.hh.service;

import com.hh.entity.TotalCheckHistory;

import java.util.Date;

public interface CheckService {
    public void addCheckHistory(String tel, int id, Date date);
    public TotalCheckHistory getCheckHistory(String tel);
}
