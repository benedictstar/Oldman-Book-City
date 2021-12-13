package com.hh.service.Impl;

import com.hh.entity.User;
import com.hh.repository.Impl.RegisterReponsitoryImpl;
import com.hh.repository.RegisterRepository;
import com.hh.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {
    private RegisterRepository registerRepository=new RegisterReponsitoryImpl();
    @Override
    public Integer register(String name, String password, String tel, String email) {
        return registerRepository.register(name,password,tel,email);
    }
}
