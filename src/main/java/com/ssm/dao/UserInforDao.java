package com.ssm.dao;

import com.ssm.pojo.UserInfor;

import java.util.List;

public interface UserInforDao {
    /**
     * 查询用户，通过id、name、phone查询用户
     * @param userInfor 用户（id/name/phone）
     * @return userInfor
     */
    public UserInfor findByCodition(UserInfor userInfor);

    /**
     * 获取所有用户
     * @return 用户
     */
    public List<UserInfor> findAllUser();
}
