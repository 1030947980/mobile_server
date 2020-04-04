package com.ssm.dao;

import com.ssm.pojo.UserInfor;

import java.util.List;

public interface UserInforDao {
    /**
     * ��ѯ�û���ͨ��id��name��phone��ѯ�û�
     * @param userInfor �û���id/name/phone��
     * @return userInfor
     */
    public UserInfor findByCodition(UserInfor userInfor);

    /**
     * ��ȡ�����û�
     * @return �û�
     */
    public List<UserInfor> findAllUser();
}
