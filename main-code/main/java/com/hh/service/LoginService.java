package com.hh.service;

import com.hh.entity.SuperUser;
import com.hh.entity.User;

public interface LoginService {
    public User login(String name, String password);
    public SuperUser superlogin(String name, String password);
}
