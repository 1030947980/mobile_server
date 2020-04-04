package com.ssm.dao;

import com.ssm.pojo.UserInfor;

import java.util.List;

public interface UserInforDao {
    /**
     *�û���ע��
     * @param userInfor
     * @return
     */
    int newUserByName(UserInfor userInfor);
    int newUserByPhone(UserInfor userInfor);
    /**
     * ��ѯ�û���ͨ��id��name��phone��ѯ�û�
     * @param userInfor �û���id/name/phone��
     * @return userInfor
     */
    UserInfor findByCondition(UserInfor userInfor);

    /**
     * ��ȡ�����û�
     * @return �û�
     */
    List<UserInfor> findAllUser();
}
