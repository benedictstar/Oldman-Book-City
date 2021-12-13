package com.hh.entity;

import java.util.List;

public class TotalBuyHistory {
    private List<buyHistory> buyHistories;

    public TotalBuyHistory(List<buyHistory> buyHistories) {
        this.buyHistories = buyHistories;
    }

    public List<buyHistory> getBuyHistories() {
        return buyHistories;
    }

    public void setBuyHistories(List<buyHistory> buyHistories) {
        this.buyHistories = buyHistories;
    }
}
