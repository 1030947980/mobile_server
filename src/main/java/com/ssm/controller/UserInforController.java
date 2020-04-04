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

    //用户名登陆
    @RequestMapping("/userNameLogin")
    public String userNameLogin(@RequestParam("name") String name,@RequestParam("password") String password){
        return userInforService.UserNameLogin(name,password);
    }

    //手机登录
    @RequestMapping("/userPhoneLogin")
    public String userPhoneLogin(@RequestParam("phone") String phone,@RequestParam("code") String code,
                                 HttpServletRequest request,HttpServletResponse response){
        return userInforService.PhoneLogin(phone,code,request,response);
    }

    //用户名注册
    @RequestMapping("/userNameRegister")
    public String userNameRegister(@RequestParam("name") String name,@RequestParam("password") String password){
      return  userInforService.userNameRegister(name,password);
    }

    //用户手机注册
    @RequestMapping("/userPhoneRegister")
    public String userPhoneRegister(@RequestParam("phone") String phone,@RequestParam("code") String code,
                                    HttpServletRequest request,HttpServletResponse response){
        return userInforService.phoneRegister(phone,code,request,response);
    }

    //发送注册短信  将phone code加入到cookie中并且设置时长为5分钟
    @RequestMapping("/sendRegisterMessage")
    public String sendRegisterMessage(@RequestParam("phone") String phone, HttpServletResponse response) throws Exception {
        int min=5;
        //手机未被绑定
        if(userInforService.phoneCheck(phone)){
            String code = ZhenziSms.getInstance().sendMessage(phone);
            //创建cookie  map(phone,code)
            Cookie cookie = new Cookie(phone,code);
            //设置cookie时长
            cookie.setMaxAge(60*5);
            response.addCookie(cookie);
            return "SUCCESS";
        }
        else{
            return "EXIST";
        }
    }
    //发送登陆短信
    @RequestMapping("/sendLoginMessage")
    public String sendLoginMessage(@RequestParam("phone") String phone, HttpServletResponse response) throws Exception {
        int min=5;
        //手机不存在
        if(userInforService.phoneCheck(phone)){
            return "NONE";
        }
        else{
            String code = ZhenziSms.getInstance().sendMessage(phone);
            Cookie cookie = new Cookie(phone,code);
            //创建cookie  map(phone,code)
            //设置cookie时长
            cookie.setMaxAge(60*min);
            response.addCookie(cookie);
            return "SUCCESS";
        }
    }
}
