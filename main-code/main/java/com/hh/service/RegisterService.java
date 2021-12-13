package com.hh.service;

import com.hh.entity.User;

public interface RegisterService {
    public Integer register(String name, String password, String tel, String email);
}
