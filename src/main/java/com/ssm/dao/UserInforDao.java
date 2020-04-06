package com.ssm.dao;

import com.ssm.pojo.UserInfor;

import java.util.List;

public interface UserInforDao {
    /**
     *用户名注册
     */
    int newUserByName(UserInfor userInfor);

    /**
     * 手机注册
     */
    int newUserByPhone(UserInfor userInfor);
    /**
     * @param userInfor 修改用户信息
     * @return
     */
    int updateUserInfor(UserInfor userInfor);
    /**
     * 查询用户，name、phone,用于登陆
     * @param userInfor 用户（id/name/phone）
     * @return userInfor
     */
    UserInfor findUser(UserInfor userInfor);
    /**
     * 查询用户，name、phone,id,nickname
     * @param userInfor 用户（id/name/phone）
     * @return userInfor
     */
    UserInfor findByCondition(UserInfor userInfor);
    /**
     * 修改密码
     * @param userInfor 修改密码
     * @return
     */
//    int changePassword(UserInfor userInfor);
    /**
     * 获取所有用户
     * @return 用户
     */
    List<UserInfor> findAllUser();
}
