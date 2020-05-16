package com.ssm.service.impl;

import com.ssm.dao.PhoneInforDao;
import com.ssm.service.PhoneInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneInforServiceImpl implements PhoneInforService {
    @Autowired
    PhoneInforDao phoneInforDao;

    @Override
    public int getPagePhoneInfor() {
        return 0;
    }
}
