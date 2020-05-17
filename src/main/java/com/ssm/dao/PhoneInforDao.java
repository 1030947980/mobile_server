package com.ssm.dao;


import com.ssm.pojo.PhoneInfor;

import java.util.List;

public interface PhoneInforDao {

    List<PhoneInfor> getAllPhoneInfor();
    List<PhoneInfor> getPagePhoneInfor(int currentIndex,int pageSize);
    int getPhoneInforTotal();
    int changePhoneInforState(int phone_id,int phone_state);
}
