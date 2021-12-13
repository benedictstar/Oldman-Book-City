package com.hh.service.Impl;


import com.hh.entity.SuperUser;
import com.hh.entity.User;
import com.hh.repository.Impl.UserRepositoryImpl;
import com.hh.repository.UserRepository;
import com.hh.service.LoginService;

public class LoginServiveImpl implements LoginService {
    //引入repository层对象，方便调用操作
    private UserRepository userRepository=new UserRepositoryImpl();
    //调用接口函数，并返回值
    @Override
    public User login(String name, String password) {
        User user=userRepository.login(name,password);
        return user;

    }

    @Override
    public SuperUser superlogin(String name, String password) {
        SuperUser user=userRepository.superLogin(name,password);
        return user;
    }
}
