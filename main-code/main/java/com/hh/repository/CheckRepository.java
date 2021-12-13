package com.hh.repository;

import com.hh.entity.checkHistory;

import java.sql.Timestamp;
import java.util.List;

public interface CheckRepository {
    public void addCheckHistory(String tel, int id, Timestamp date);
    public List<checkHistory> getCheckHistory(String tel);
}
