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
     * ��ѯ�û���name��phone,���ڵ�½ ��ѯ�û����Ƿ����
     * @param userInfor �û���id/name/phone��
     * @return userInfor
     */
    UserInfor findUser(UserInfor userInfor);
    /**
     * ��ѯ�û���name��phone,id,nickname  �����û����������û�
     * @param userInfor �û���id/name/phone��
     * @return userInfor
     */
    UserInfor findByCondition(UserInfor userInfor);
    /**
     * �޸����� ����Ա
     * @return
     */
    int changePassword(String user_name,String user_password);
    /**
     * ��ȡ�����û� �����û���Ѱ�����û���
     * @return �û�
     */
    List<UserInfor> findAllUser();

    /**
     * �����û�״̬ ����Ա���ã��û�ע��
     * @param user_id
     * @param user_state
     * @return
     */
    int editUserState(int user_id,int user_state);

    /**
     * ��ȡ��ҳ�û� ����Ա����
     * @param currentIndex
     * @return
     */
    List<UserInfor> getPageUserInfor(int currentIndex);

    /**
     * ��ȡ�û����� ����Ա����
     * @return
     */
    int getUserTotal();


}
