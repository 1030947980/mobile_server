package com.ssm.service.impl;

import com.ssm.dao.PhoneInforDao;
import com.ssm.pojo.PhoneInfor;
import com.ssm.pojo.PhoneCondition;
import com.ssm.pojo.RankPhone;
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

    @Override
    public PhoneInfor getPhoneInforById(int phone_id) {
        return phoneInforDao.getPhoneInforById(phone_id);
    }

    @Override
    public int getPhoneIdByPhoneModel(String phone_model) {
        PhoneInfor phoneInfor = phoneInforDao.getPhoneIdByPhoneModel(phone_model);
        if (phoneInfor==null)
        {
            return 0;
        }
        return phoneInfor.getPhone_id();
    }

    @Override
    public List<PhoneInfor> getPhoneInforByCondition(int pricelow,int priceup,double sizelow,double sizeup,String phonecpu,
                                                     String phonetype,String phonenetwork,String phoneappearance,int current_page,int pageSize)
    {
        int currentIndex =(current_page-1)*pageSize;
        PhoneCondition phoneCondition = new PhoneCondition();
        phoneCondition.setPricelow(pricelow);
        phoneCondition.setPriceup(priceup);

        phoneCondition.setSizelow(sizelow);
        phoneCondition.setSizeup(sizeup);

        if(!phonecpu.equals("不限")){
            phoneCondition.setPhonecpu(phonecpu);
        }
        if(!phonetype.equals("不限")){
            phoneCondition.setPhonetype(phonetype);
        }
        if(!phonenetwork.equals("不限")){
            phoneCondition.setPhonenetwork(phonenetwork);
        }
        if(!phoneappearance.equals("不限")){
            phoneCondition.setPhoneappearance(phoneappearance);
        }
        phoneCondition.setCurrentIndex(currentIndex);
        phoneCondition.setPageSize(pageSize);
        return phoneInforDao.getPhoneInforByCondition(phoneCondition);
    }

    @Override
    public int getPhoneInforByConditionTotal(int pricelow, int priceup, double sizelow, double sizeup,
                                             String phonecpu, String phonetype, String phonenetwork, String phoneappearance) {
        PhoneCondition phoneCondition = new PhoneCondition();
        phoneCondition.setPricelow(pricelow);
        phoneCondition.setPriceup(priceup);

        phoneCondition.setSizelow(sizelow);
        phoneCondition.setSizeup(sizeup);

        if(!phonecpu.equals("不限")){
            phoneCondition.setPhonecpu(phonecpu);
        }
        if(!phonetype.equals("不限")){
            phoneCondition.setPhonetype(phonetype);
        }
        if(!phonenetwork.equals("不限")){
            phoneCondition.setPhonenetwork(phonenetwork);
        }
        if(!phoneappearance.equals("不限")){
            phoneCondition.setPhoneappearance(phoneappearance);
        }
        return phoneInforDao.getPhoneInforByConditionTotal(phoneCondition);
    }

    @Override
    public List<RankPhone> getAllrank() {
        return phoneInforDao.getAllrank();
    }

    @Override
    public List<RankPhone> getRankByRankType(String rank_type) {
        return phoneInforDao.getRankByRankType(rank_type);
    }
}
