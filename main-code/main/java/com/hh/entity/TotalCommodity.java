package com.hh.entity;

import java.util.List;

public class TotalCommodity {
    private List<Commodity> commodities;

    public List<Commodity> getCommodities() {
        return commodities;
    }

    public void setCommodities(List<Commodity> commodities) {
        this.commodities = commodities;
    }

    public TotalCommodity(List<Commodity> commodities) {
        this.commodities = commodities;
    }
}
