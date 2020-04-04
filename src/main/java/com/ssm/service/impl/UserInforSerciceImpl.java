package com.ssm.service.impl;

import com.ssm.dao.UserInforDao;
import com.ssm.pojo.UserInfor;
import com.ssm.service.UserInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInforSerciceImpl implements UserInforService {
    @Autowired
    UserInforDao userInforDao;


    @Override
    public Boolean userNameCheck(String name) {
        UserInfor userInfor = new UserInfor();
        userInfor.setUser_name(name);
        return userInforDao.findByCodition(userInfor)==null;
    }

    @Override
    public Boolean phoneCheck(String phone) {
        UserInfor userInfor = new UserInfor();
        userInfor.setUser_phone(phone);
        return userInforDao.findByCodition(userInfor)==null;
    }

    @Override
    public UserInfor findUserById(int id) {
        UserInfor userInfor = new UserInfor();
        userInfor.setUser_id(id);
        return userInforDao.findByCodition(userInfor);
    }

    @Override
    public UserInfor findUserByPhone(String phone) {
        UserInfor userInfor = new UserInfor();
        userInfor.setUser_phone(phone);
        return userInforDao.findByCodition(userInfor);
    }

    @Override
    public UserInfor findUserByName(String name) {
        UserInfor userInfor = new UserInfor();
        userInfor.setUser_name(name);
        return userInforDao.findByCodition(userInfor);
    }

    @Override
    public List<UserInfor> findAllUser() {
        return userInforDao.findAllUser();
    }
}
