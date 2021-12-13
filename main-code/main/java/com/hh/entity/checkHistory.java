package com.hh.entity;

import java.sql.Timestamp;

public class checkHistory {
    private String usertel;
    private String commodity_name;
    private Timestamp date;
    private int id;

    public checkHistory(String usertel, String commodity_name, Timestamp date, int id) {
        this.usertel = usertel;
        this.commodity_name = commodity_name;
        this.date = date;
        this.id = id;
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
