package com.ssm.controller;

import com.ssm.pojo.PhoneInfor;
import com.ssm.service.PhoneInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneInforController {
    @Autowired
    PhoneInforService phoneInforService;

    @RequestMapping("/getAllPhoneInfor")
    public List<PhoneInfor> getAllPhoneInfor(){
        return phoneInforService.getAllPhoneInfor();
    }
    @RequestMapping("/getPagePhoneInfor")
    public List<PhoneInfor> getPagePhoneInfor(@RequestParam("current_page")int current_page,
                                              @RequestParam("pageSize") int pageSize){
        return phoneInforService.getPagePhoneInfor(current_page, pageSize);
    }
    @RequestMapping("/getPhoneInforTotal")
    public int getPhoneInforTotal(){
        return phoneInforService.getPhoneInforTotal();
    }
    @RequestMapping("/changePhoneInforState")
    public void changePhoneInforState(@RequestParam("phone_id")int phone_id,
                                      @RequestParam("phone_state")int phone_state){
        phoneInforService.changePhoneInforState(phone_id, phone_state);
    }
    @RequestMapping("/getPhoneHardwareInfor")
    public String getPhoneHardwareInfor(@RequestParam("phone_id")int phone_id){
        return phoneInforService.getPhoneHardwareInfor(phone_id);
    }

    @RequestMapping("/getPhoneInforById")
    public PhoneInfor getPhoneInforById(@RequestParam("phone_id")int phone_id){
        return phoneInforService.getPhoneInforById(phone_id);
    }
    @RequestMapping("/getPhoneInforByCondition")
    public List<PhoneInfor> getPhoneInforByCondition(@RequestParam("pricelow")int pricelow,
                                                     @RequestParam("priceup")int priceup,
                                                     @RequestParam("sizelow")double sizelow,
                                                     @RequestParam("sizeup")double sizeup,
                                                     @RequestParam("phonecpu")String phonecpu,
                                                     @RequestParam("phonetype")String phonetype,
                                                     @RequestParam("phonenetwork")String phonenetwork,
                                                     @RequestParam("phoneappearance")String phoneappearance,
                                                     @RequestParam("current_page")int current_page,
                                                     @RequestParam("pageSize")int pageSize){
        return phoneInforService.getPhoneInforByCondition(pricelow, priceup, sizelow, sizeup, phonecpu,
                                                phonetype,phonenetwork, phoneappearance, current_page, pageSize);
    }
    @RequestMapping("/getPhoneInforByConditionTotal")
    public int getPhoneInforByConditionTotal(@RequestParam("pricelow")int pricelow,
                                                     @RequestParam("priceup")int priceup,
                                                     @RequestParam("sizelow")double sizelow,
                                                     @RequestParam("sizeup")double sizeup,
                                                     @RequestParam("phonecpu")String phonecpu,
                                                     @RequestParam("phonetype")String phonetype,
                                                     @RequestParam("phonenetwork")String phonenetwork,
                                                     @RequestParam("phoneappearance")String phoneappearance){
        return phoneInforService.getPhoneInforByConditionTotal(pricelow, priceup, sizelow, sizeup, phonecpu,
                phonetype,phonenetwork, phoneappearance);
    }
    @RequestMapping("/getPhoneIdByPhoneModel")
    public int getPhoneIdByPhoneModel(@RequestParam("phone_mode")String phone_mode){
        return phoneInforService.getPhoneIdByPhoneModel(phone_mode);
    }
}
