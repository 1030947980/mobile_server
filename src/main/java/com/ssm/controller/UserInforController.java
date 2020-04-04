package com.ssm.controller;

import com.ssm.service.UserInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserInforController {
    @Autowired
    UserInforService userInforService;

    @RequestMapping("/userNameLogin")
    public String userNameLogin(@RequestParam("name") String name,@RequestParam("passowrd") String password){
        if(userInforService.userNameCheck(name)){

            return "SUCCESS";
        }
        else{
            return "ERROR";
        }
    }
}
