package com.ssm.service;

import com.ssm.pojo.UserInfor;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public interface UserInforService {
    Boolean userNameCheck(String name);
    Boolean phoneCheck(String phone);
    UserInfor findUserById(int id);
    UserInfor findUserByPhone(String phone);
    UserInfor findUserByName(String name);
    List<UserInfor> findAllUser();
}
