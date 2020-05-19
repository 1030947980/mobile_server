package com.ssm.service.impl;

import com.ssm.dao.PhoneInforDao;
import com.ssm.pojo.PhoneInfor;
import com.ssm.service.PhoneInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneInforServiceImpl implements PhoneInforService {
    @Autowired
    PhoneInforDao phoneInforDao;

    @Override
    public List<PhoneInfor> getAllPhoneInfor() {
        return phoneInforDao.getAllPhoneInfor();
    }

    @Override
    public List<PhoneInfor> getPagePhoneInfor(int current_page, int pageSize) {
        int currentIndex =(current_page-1)*pageSize;
        return phoneInforDao.getPagePhoneInfor(currentIndex, pageSize);
    }

    @Override
    public int getPhoneInforTotal() {
        return phoneInforDao.getPhoneInforTotal();
    }

    @Override
    public void changePhoneInforState(int phone_id, int phone_state) {
        phoneInforDao.changePhoneInforState(phone_id, phone_state);
    }

    @Override
    public String getPhoneHardwareInfor(int phone_id) {
        return phoneInforDao.getPhoneHardwareInfor(phone_id);
    }
}
