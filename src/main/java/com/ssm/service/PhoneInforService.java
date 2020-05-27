package com.ssm.service;

import com.ssm.pojo.PhoneInfor;

import java.util.List;

public interface PhoneInforService {
    List<PhoneInfor> getAllPhoneInfor();
    List<PhoneInfor> getPagePhoneInfor(int current_page,int pageSize);
    int getPhoneInforTotal();
    void changePhoneInforState(int phone_id,int phone_state);
    String getPhoneHardwareInfor(int phone_id);
    PhoneInfor getPhoneInforById(int phone_id);
    int getPhoneIdByPhoneModel(String phone_mode);
    List<PhoneInfor> getPhoneInforByCondition(int pricelow,int priceup,double sizelow,double sizeup,String phonecpu,
                                              String phonetype,String phonenetwork,String phoneappearance,int current_page,int pageSize);
    int getPhoneInforByConditionTotal(int pricelow,int priceup,double sizelow,double sizeup,String phonecpu,
                                              String phonetype,String phonenetwork,String phoneappearance);
}
