package com.hh.service.Impl;

import com.hh.entity.TotalCheckHistory;
import com.hh.repository.CheckRepository;
import com.hh.repository.Impl.ChechRepositoryImpl;
import com.hh.service.CheckService;

import java.sql.Timestamp;
import java.util.Date;

public class CheckServiceImpl implements CheckService {
    private CheckRepository checkRepository=new ChechRepositoryImpl();
    @Override
    public void addCheckHistory(String tel, int id, Date date) {
        Timestamp timestamp=new Timestamp(date.getTime());
        checkRepository.addCheckHistory(tel,id,timestamp);
    }

    @Override
    public TotalCheckHistory getCheckHistory(String tel) {
        return new TotalCheckHistory(checkRepository.getCheckHistory(tel));
    }
}
