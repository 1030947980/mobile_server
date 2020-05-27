package com.ssm.dao;


import com.ssm.pojo.PhoneInfor;
import com.ssm.pojo.PhoneCondition;

import java.util.List;

public interface PhoneInforDao {

    List<PhoneInfor> getAllPhoneInfor();
    List<PhoneInfor> getPagePhoneInfor(int currentIndex,int pageSize);
    int getPhoneInforTotal();
    int changePhoneInforState(int phone_id,int phone_state);
    String getPhoneHardwareInfor(int phone_id);
    PhoneInfor getPhoneInforById(int phone_id);
    int getPhoneIdByPhoneModel(String phone_model);
    List<PhoneInfor> getPhoneInforByCondition(PhoneCondition phoneCondition);
    int getPhoneInforByConditionTotal(PhoneCondition phoneCondition);
}
