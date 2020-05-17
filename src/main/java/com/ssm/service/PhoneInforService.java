package com.ssm.service;

import com.ssm.pojo.PhoneInfor;

import java.util.List;

public interface PhoneInforService {
    List<PhoneInfor> getAllPhoneInfor();
    List<PhoneInfor> getPagePhoneInfor(int current_page,int pageSize);
    int getPhoneInforTotal();
    void changePhoneInforState(int phone_id,int phone_state);
}
