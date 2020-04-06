package com.ssm.service;

import com.ssm.pojo.UserInfor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserInforService {
    String UserNameLogin(String name,String password);
    String PhoneLogin(String phone, String code, HttpServletRequest request,HttpServletResponse response);
    String userNameRegister(String name,String password);
    String phoneRegister(String phone, String code, HttpServletRequest request,HttpServletResponse response);
    Boolean userNameCheck(String name);
    Boolean phoneCheck(String phone);
    String changePassword(String name,String oldPassword,String newPassword);
    String updateUserInfor(int id,String name,String nickName,String avatar,String sex,String phone);
    UserInfor findUserById(int id);
    UserInfor findUserByPhone(String phone);
    UserInfor findUserByName(String name);
    UserInfor findUserByNickName(String nickName);
    List<UserInfor> findAllUser();
}
