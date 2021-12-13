package com.hh.entity;

public class Commodity {
    public Commodity(int com_id,String commodityname, String detail, String author, double price, String url, String face, int buynum, int totalnum) {
        this.Commodityname = commodityname;
        this.detail = detail;
        this.author = author;
        this.price = price;
        this.url = url;
        this.face = face;
        this.buynum = buynum;
        this.totalnum = totalnum;
        this.com_id = com_id;
    }

    public String getCommodityname() {
        return Commodityname;
    }

    public void setCommodityname(String commodityname) {
        this.Commodityname = commodityname;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public int getBuynum() {
        return buynum;
    }

    public void setBuynum(int buynum) {
        this.buynum = buynum;
    }

    public int getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(int totalnum) {
        this.totalnum = totalnum;
    }

    public int getCom_id() {
        return com_id;
    }

    public void setCom_id(int com_id) {
        this.com_id = com_id;
    }

    private String Commodityname;
    private String detail;
    private String author;
    private double price;
    private String url;
    private String face;
    private int buynum;
    private int totalnum;
    private int com_id;

}

