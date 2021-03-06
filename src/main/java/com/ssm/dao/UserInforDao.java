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
     * 查询用户，name、phone,用于登陆 查询用户所是否存在
     * @param userInfor 用户（id/name/phone）
     * @return userInfor
     */
    UserInfor findUser(UserInfor userInfor);
    /**
     * 查询用户，name、phone,id,nickname  用于用户搜索其他用户
     * @param userInfor 用户（id/name/phone）
     * @return userInfor
     */
    UserInfor findByCondition(UserInfor userInfor);
    /**
     * 修改密码 管理员
     * @return
     */
    int changePassword(String user_name,String user_password);
    /**
     * 获取所有用户 用于用户查寻所有用户。
     * @return 用户
     */
    List<UserInfor> findAllUser();

    /**
     * 更改用户状态 管理员调用，用户注销
     * @param user_id
     * @param user_state
     * @return
     */
    int editUserState(int user_id,int user_state);

    /**
     * 获取分页用户 管理员调用
     * @param currentIndex
     * @return
     */
    List<UserInfor> getPageUserInfor(int currentIndex);

    /**
     * 获取用户总数 管理员调用
     * @return
     */
    int getUserTotal();


}
