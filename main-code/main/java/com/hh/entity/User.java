package com.hh.entity;

public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String name, String password, String tel, String email) {
        this.name = name;
        this.password = password;
        this.tel = tel;
        this.email = email;
    }

    private String name;
    private String password;
    private String tel;
    private String email;


}
