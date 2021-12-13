package com.hh.entity;

import java.util.List;

public class ShoppingList {
    private List<Commodity> commodity;

    public List<Commodity> getCommodity() {
        return commodity;
    }

    public void setCommodity(List<Commodity> commodity) {
        this.commodity = commodity;
    }

    public ShoppingList(List<Commodity> commodity) {
        this.commodity = commodity;
    }
}
