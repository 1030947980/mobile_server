package com.ssm.service.impl;

import com.ssm.dao.UserInforDao;
import com.ssm.service.UserInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInforSerciceImpl implements UserInforService {
    @Autowired
    UserInforDao userInforDao;

    @Override
    public Boolean userNameCheck(String name){
        return true;
    }
}
