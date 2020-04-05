package com.ssm.service.impl;

import com.ssm.dao.UserInforDao;
import com.ssm.pojo.UserInfor;
import com.ssm.service.UserInforService;
import com.ssm.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class UserInforSerciceImpl implements UserInforService {
    @Autowired
    UserInforDao userInforDao;

    /**
     * 用户名登陆
     */
    @Override
    public String UserNameLogin(String name, String password) {
        UserInfor userInfor = new UserInfor();
        userInfor.setUser_name(name);
        UserInfor getUser=userInforDao.findByCondition(userInfor);
        //用户是否存在
        if (getUser!=null){
            //用户是否被禁用
            if(getUser.getUser_state()==0){
                //用户密码是否正确
                if(getUser.getUser_password().equals(MD5.getInstance().computeMD5(password,name))){
                    return "SUCCESS";
                }
                else{
                    return "ERROR";
                }
            }
            else{
                return "DISABLE";
            }
        }
        else {
            return "NONE";
        }
    }
    /**
     * 手机登陆
     */
    @Override
    public String PhoneLogin(String phone, String code, HttpServletRequest request,HttpServletResponse response) {
        //手机号码不存在
        UserInfor userInfor = new UserInfor();
        userInfor.setUser_phone(phone);
        UserInfor getUser=userInforDao.findByCondition(userInfor);
        if (getUser==null){
            return "NONE";
        }
        else{
            if(getUser.getUser_state()==0){
                Cookie[] cookies = request.getCookies();
                String cookieCode ="";
                //cookie 不为空
                if(cookies!=null){
                    for(Cookie cookie:cookies){
                        //cookie phone 与phone相同
                        if(cookie.getName().equals(phone)){
                            //获取对应map的value
                            cookieCode =cookie.getValue();
                        }
                    }
                    //验证码正确
                    if(cookieCode.equals(code)){
                        //删除cookie 只需创建一个与之前cookie 的value和MaxAge不同的cookie加入进去即可
                        Cookie cookie = new Cookie(phone,null);
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                        return "SUCCESS";
                    }
                    //验证码错误
                    else{
                        return "ERROR";
                    }
                }
                //验证码失效
                else {
                    return "TIMEOUT";
                }
            }
            else{
                return "DISABLE";
            }
        }
    }
    /**
     * 用户名注册
     */
    @Override
    public String userNameRegister(String name,String password) {
        UserInfor userInfor = new UserInfor();
        userInfor.setUser_name(name);
        userInfor.setUser_nickname(name);
        userInfor.setUser_password(MD5.getInstance().computeMD5(password,name));
        if(userNameCheck(name)){
            userInforDao.newUserByName(userInfor);
            return "SUCCESS";
        }
        else {
            return "EXIST";
        }
    }
    /**
     * 手机注册
     */
    @Override
    public String phoneRegister(String phone, String code, HttpServletRequest request, HttpServletResponse response) {
        //手机未被绑定
        if(phoneCheck(phone)){
            UserInfor userInfor = new UserInfor();
            Cookie[] cookies = request.getCookies();
            String cookieCode ="";
            //cookie不为空
            if(cookies!=null){
                for(Cookie cookie:cookies){
                    //cookie phone 与phone相同
                    if(cookie.getName().equals(phone)){
                        //获取对应map的value
                        cookieCode =cookie.getValue();
                    }
                }
                //验证码正确
                if(cookieCode.equals(code)){
                    userInfor .setUser_name(phone);
                    userInfor.setUser_password(MD5.getInstance().computeMD5(phone,phone));
                    userInfor.setUser_nickname(phone);
                    userInfor.setUser_phone(phone);
                    userInforDao.newUserByPhone(userInfor);
                    //删除cookie 只需创建一个与之前cookie 的value和MaxAge不同的cookie加入进去即可
                    Cookie cookie = new Cookie(phone,null);
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    return "SUCCESS";
                }
                //验证码错误
                else{
                    return "ERROR";
                }
            }
            //验证码失效
            else {
                return "TIMEOUT";
            }
        }
        else{
            return "EXIST";
        }
    }
    /**
     * 用户名是否存在
     */
    @Override
    public Boolean userNameCheck(String name) {
        UserInfor userInfor = new UserInfor();
        userInfor.setUser_name(name);
        return userInforDao.findByCondition(userInfor)==null;
    }
    /**
     * 手机是否已被绑定
     */
    @Override
    public Boolean phoneCheck(String phone) {
        UserInfor userInfor = new UserInfor();
        userInfor.setUser_phone(phone);
        return userInforDao.findByCondition(userInfor)==null;
    }
    /**
     * ID查找用户
     */
    @Override
    public UserInfor findUserById(int id) {
        UserInfor userInfor = new UserInfor();
        userInfor.setUser_id(id);
        return userInforDao.findByCondition(userInfor);
    }
    /**
     * 手机查找用户
     */
    @Override
    public UserInfor findUserByPhone(String phone) {
        UserInfor userInfor = new UserInfor();
        userInfor.setUser_phone(phone);
        return userInforDao.findByCondition(userInfor);
    }
    /**
     * 用户名查找用户
     */
    @Override
    public UserInfor findUserByName(String name) {
        UserInfor userInfor = new UserInfor();
        userInfor.setUser_name(name);
        return userInforDao.findByCondition(userInfor);
    }
    /**
     * 查询所有用户
     */
    @Override
    public List<UserInfor> findAllUser() {
        return userInforDao.findAllUser();
    }
}
