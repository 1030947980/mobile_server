package com.ssm.dao;

import com.ssm.pojo.UserInfor;

import java.util.List;

public interface UserInforDao {
    /**
     *用户名注册
     * @param userInfor
     * @return
     */
    int newUserByName(UserInfor userInfor);
    int newUserByPhone(UserInfor userInfor);
    /**
     * 查询用户，name、phone,用于登陆
     * @param userInfor 用户（id/name/phone）
     * @return userInfor
     */
    UserInfor findByCondition(UserInfor userInfor);
    /**
     * 获取所有用户
     * @return 用户
     */
    List<UserInfor> findAllUser();
}
