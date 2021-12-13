package com.hh.repository;

import com.hh.entity.SuperUser;
import com.hh.entity.User;

public interface UserRepository {
    public User login(String name,String password);
    public SuperUser superLogin(String name,String password);
}
