package com.hh.entity;


import java.sql.Timestamp;

public class buyHistory {
    private int id;
    private String usertel;
    private String commodity_name;
    private double commodity_price;
    private int num;
    private Timestamp date;

    public buyHistory(int id, String usertel, String commodity_name, double commodity_price, int num, Timestamp date) {
        this.id = id;
        this.usertel = usertel;
        this.commodity_name = commodity_name;
        this.commodity_price = commodity_price;
        this.num = num;
        this.date = date;
    }

    public String getUsertel() {
        return usertel;
    }

    public void setUsertel(String usertel) {
        this.usertel = usertel;
    }

    public String getCommodity_name() {
        return commodity_name;
    }

    public void setCommodity_name(String commodity_name) {
        this.commodity_name = commodity_name;
    }

    public double getCommodity_price() {
        return commodity_price;
    }

    public void setCommodity_price(double commodity_price) {
        this.commodity_price = commodity_price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
