package com.ssm.dao;

import com.ssm.pojo.UserInfor;

import java.util.List;

public interface UserInforDao {
    /**
     *�û���ע��
     */
    int newUserByName(UserInfor userInfor);

    /**
     * �ֻ�ע��
     */
    int newUserByPhone(UserInfor userInfor);
    /**
     * @param userInfor �޸��û���Ϣ
     * @return
     */
    int updateUserInfor(UserInfor userInfor);
    /**
     * ��ѯ�û���name��phone,���ڵ�½
     * @param userInfor �û���id/name/phone��
     * @return userInfor
     */
    UserInfor findUser(UserInfor userInfor);
    /**
     * ��ѯ�û���name��phone,id,nickname
     * @param userInfor �û���id/name/phone��
     * @return userInfor
     */
    UserInfor findByCondition(UserInfor userInfor);
    /**
     * �޸�����
     * @param userInfor �޸�����
     * @return
     */
//    int changePassword(UserInfor userInfor);
    /**
     * ��ȡ�����û�
     * @return �û�
     */
    List<UserInfor> findAllUser();
}
