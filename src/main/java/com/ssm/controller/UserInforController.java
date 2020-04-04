package com.ssm.controller;

import com.ssm.service.UserInforService;
import com.ssm.util.ZhenziSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
public class UserInforController {
    @Autowired
    UserInforService userInforService;

    //�û�����½
    @RequestMapping("/userNameLogin")
    public String userNameLogin(@RequestParam("name") String name,@RequestParam("password") String password){
        return userInforService.UserNameLogin(name,password);
    }

    //�ֻ���¼
    @RequestMapping("/userPhoneLogin")
    public String userPhoneLogin(@RequestParam("phone") String phone,@RequestParam("code") String code,
                                 HttpServletRequest request,HttpServletResponse response){
        return userInforService.PhoneLogin(phone,code,request,response);
    }

    //�û���ע��
    @RequestMapping("/userNameRegister")
    public String userNameRegister(@RequestParam("name") String name,@RequestParam("password") String password){
      return  userInforService.userNameRegister(name,password);
    }

    //�û��ֻ�ע��
    @RequestMapping("/userPhoneRegister")
    public String userPhoneRegister(@RequestParam("phone") String phone,@RequestParam("code") String code,
                                    HttpServletRequest request,HttpServletResponse response){
        return userInforService.phoneRegister(phone,code,request,response);
    }

    //����ע�����  ��phone code���뵽cookie�в�������ʱ��Ϊ5����
    @RequestMapping("/sendRegisterMessage")
    public String sendRegisterMessage(@RequestParam("phone") String phone, HttpServletResponse response) throws Exception {
        int min=5;
        //�ֻ�δ����
        if(userInforService.phoneCheck(phone)){
            String code = ZhenziSms.getInstance().sendMessage(phone);
            //����cookie  map(phone,code)
            Cookie cookie = new Cookie(phone,code);
            //����cookieʱ��
            cookie.setMaxAge(60*5);
            response.addCookie(cookie);
            return "SUCCESS";
        }
        else{
            return "EXIST";
        }
    }
    //���͵�½����
    @RequestMapping("/sendLoginMessage")
    public String sendLoginMessage(@RequestParam("phone") String phone, HttpServletResponse response) throws Exception {
        int min=5;
        //�ֻ�������
        if(userInforService.phoneCheck(phone)){
            return "NONE";
        }
        else{
            String code = ZhenziSms.getInstance().sendMessage(phone);
            Cookie cookie = new Cookie(phone,code);
            //����cookie  map(phone,code)
            //����cookieʱ��
            cookie.setMaxAge(60*min);
            response.addCookie(cookie);
            return "SUCCESS";
        }
    }
}
