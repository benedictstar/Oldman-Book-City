package com.hh.entity;

import java.util.List;

public class TotalCheckHistory {
    private List<checkHistory> checkHistories;

    public TotalCheckHistory(List<checkHistory> checkHistories) {
        this.checkHistories = checkHistories;
    }

    public List<checkHistory> getCheckHistories() {
        return checkHistories;
    }

    public void setCheckHistories(List<checkHistory> checkHistories) {
        this.checkHistories = checkHistories;
    }
}
