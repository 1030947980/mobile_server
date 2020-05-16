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

    //�û�����½
    @RequestMapping("/userNameLogin")
    public String userNameLogin(@RequestParam("name") String name,@RequestParam("password") String password){
        System.out.println("controller��½"+name);
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

    //��ѯ�û��û�id
    @RequestMapping("/findUserById")
    public UserInfor findUserById(@RequestParam("id") int id){

        return userInforService.findUserById(id);
    }

    //��ѯ�û��û�phone
    @RequestMapping("/findUserByPhone")
    public UserInfor findUserByPhone(@RequestParam("phone") String phone){
        return userInforService.findUserByPhone(phone);
    }

    //��ѯ�û� name
    @RequestMapping("/findUserByName")
    public UserInfor findUserByName(@RequestParam("name") String name){
        return userInforService.findUserByName(name);
    }

    //��ѯ�û� �û���
    @RequestMapping("/findUserByNickName")
    public UserInfor findUserByNickName(@RequestParam("nickName") String nickName){
        return userInforService.findUserByNickName(nickName);
    }
    //��ȡ��ҳ�û�
    @RequestMapping("/getPageUserInfor")
    public List<UserInfor> getPageUserInfor(@RequestParam("current_page")int current_page){
        return userInforService.getPageUserInfor(current_page);
    }
    //��ȡ�û�����
    @RequestMapping("/getUserTotal")
    public int getUserTotal(){
        return userInforService.getUserTotal();
    }
    //��ȡ�����û�
    @RequestMapping("/findAllUser")
    public List<UserInfor> findAll(){
        return userInforService.findAllUser();
    }

    //�޸��û���Ϣ
    @RequestMapping("/updateUserInfor")
    public String updateUserInfor(@RequestParam("id") int id,@RequestParam("name") String name,
                                  @RequestParam("nickName") String nickName,@RequestParam("avatar") String avatar,
                                  @RequestParam("sex") String sex,@RequestParam("phone") String phone){

        return userInforService.updateUserInfor(id,name,nickName,avatar,sex,phone);
    }

    //�޸��ǳ�
    @RequestMapping("/editUserNickName")
    public String editUserNickName(@RequestParam("id") int id,@RequestParam("nickName") String nickName){
        return userInforService.editUserNickName(id,nickName);
    }

    //�޸��Ա�
    @RequestMapping("/editUserSex")
    public String editUserSex(@RequestParam("id") int id,@RequestParam("sex") String sex){
        return userInforService.editUserSex(id,sex);
    }

    //�޸�����
    @RequestMapping("/editUserPassword")
    public String changePassword(@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("oldPassword") String oldPassword
            ,@RequestParam("newPassword") String newPassword){
        return userInforService.editUserPassword(id,name,oldPassword,newPassword);
    }

    //�޸�״̬
    @RequestMapping("/editUserState")
    public void editUserState(@RequestParam("user_id") int user_id,@RequestParam("user_state") int user_state){
        userInforService.editUserState(user_id,user_state);
    }

    //����ע�����  ��phone code���뵽cookie�в�������ʱ��Ϊ5����
    @RequestMapping("/sendRegisterMessage")
    public String sendRegisterMessage(@RequestParam("phone") String phone, HttpServletResponse response) throws Exception {
        //�ֻ�δ����
        if(userInforService.phoneCheck(phone)){
            String code = ZhenziSms.getInstance().sendMessage(phone);
//            ����cookie  map(phone+code�ļ���,code+phone�ļ���)
            String md5phone = MD5.getInstance().computeMD5(phone,code);
            String md5code = MD5.getInstance().computeMD5(code,phone);
            Cookie cookie = new Cookie(md5phone,md5code);
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
            String md5phone = MD5.getInstance().computeMD5(phone,code);
            String md5code = MD5.getInstance().computeMD5(code,phone);
            Cookie cookie = new Cookie(md5phone,md5code);
//            ����cookie  map(phone+code�ļ���,code+phone�ļ���)
            //����cookieʱ��
            cookie.setMaxAge(60*min);
            response.addCookie(cookie);
            return "SUCCESS";
        }
    }
}
