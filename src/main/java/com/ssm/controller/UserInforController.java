package com.ssm.controller;

import com.ssm.pojo.UserInfor;
import com.ssm.service.UserInforService;
import com.ssm.util.MD5;
import com.ssm.util.ZhenziSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
public class UserInforController {
    @Autowired
    UserInforService userInforService;

    //用户名登陆
    @RequestMapping("/userNameLogin")
    public String userNameLogin(@RequestParam("name") String name,@RequestParam("password") String password){
        System.out.println("controller登陆"+name);
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

    //查询用户用户id
    @RequestMapping("/findUserById")
    public UserInfor findUserById(@RequestParam("id") int id){

        return userInforService.findUserById(id);
    }

    //查询用户用户phone
    @RequestMapping("/findUserByPhone")
    public UserInfor findUserByPhone(@RequestParam("phone") String phone){
        return userInforService.findUserByPhone(phone);
    }

    //查询用户 name
    @RequestMapping("/findUserByName")
    public UserInfor findUserByName(@RequestParam("name") String name){
        return userInforService.findUserByName(name);
    }

    //查询用户 用户名
    @RequestMapping("/findUserByNickName")
    public UserInfor findUserByNickName(@RequestParam("nickName") String nickName){
        return userInforService.findUserByNickName(nickName);
    }
    //获取分页用户
    @RequestMapping("/getPageUserInfor")
    public List<UserInfor> getPageUserInfor(@RequestParam("current_page")int current_page){
        return userInforService.getPageUserInfor(current_page);
    }
    //获取用户总数
    @RequestMapping("/getUserTotal")
    public int getUserTotal(){
        return userInforService.getUserTotal();
    }
    //获取所有用户
    @RequestMapping("/findAllUser")
    public List<UserInfor> findAll(){
        return userInforService.findAllUser();
    }

    //修改用户信息
    @RequestMapping("/updateUserInfor")
    public String updateUserInfor(@RequestParam("id") int id,@RequestParam("name") String name,
                                  @RequestParam("nickName") String nickName,@RequestParam("avatar") String avatar,
                                  @RequestParam("sex") String sex,@RequestParam("phone") String phone){

        return userInforService.updateUserInfor(id,name,nickName,avatar,sex,phone);
    }

    //修改昵称
    @RequestMapping("/editUserNickName")
    public String editUserNickName(@RequestParam("id") int id,@RequestParam("nickName") String nickName){
        return userInforService.editUserNickName(id,nickName);
    }

    //修改性别
    @RequestMapping("/editUserSex")
    public String editUserSex(@RequestParam("id") int id,@RequestParam("sex") String sex){
        return userInforService.editUserSex(id,sex);
    }

    //修改密码
    @RequestMapping("/editUserPassword")
    public String changePassword(@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("oldPassword") String oldPassword
            ,@RequestParam("newPassword") String newPassword){
        return userInforService.editUserPassword(id,name,oldPassword,newPassword);
    }

    //修改状态
    @RequestMapping("/editUserState")
    public void editUserState(@RequestParam("user_id") int user_id,@RequestParam("user_state") int user_state){
        userInforService.editUserState(user_id,user_state);
    }

    //发送注册短信  将phone code加入到cookie中并且设置时长为5分钟
    @RequestMapping("/sendRegisterMessage")
    public String sendRegisterMessage(@RequestParam("phone") String phone, HttpServletResponse response) throws Exception {
        //手机未被绑定
        if(userInforService.phoneCheck(phone)){
            String code = ZhenziSms.getInstance().sendMessage(phone);
//            创建cookie  map(phone+code的加密,code+phone的加密)
            String md5phone = MD5.getInstance().computeMD5(phone,code);
            String md5code = MD5.getInstance().computeMD5(code,phone);
            Cookie cookie = new Cookie(md5phone,md5code);
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
            String md5phone = MD5.getInstance().computeMD5(phone,code);
            String md5code = MD5.getInstance().computeMD5(code,phone);
            Cookie cookie = new Cookie(md5phone,md5code);
//            创建cookie  map(phone+code的加密,code+phone的加密)
            //设置cookie时长
            cookie.setMaxAge(60*min);
            response.addCookie(cookie);
            return "SUCCESS";
        }
    }
}
