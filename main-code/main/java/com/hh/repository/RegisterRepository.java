package com.hh.repository;

import com.hh.entity.User;

public interface RegisterRepository {
    public Integer register(String name, String password, String tel, String email);
}
