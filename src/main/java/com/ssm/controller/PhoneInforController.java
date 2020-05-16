package com.ssm.controller;

import com.ssm.service.PhoneInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneInforController {
    @Autowired
    PhoneInforService phoneInforService;


}
