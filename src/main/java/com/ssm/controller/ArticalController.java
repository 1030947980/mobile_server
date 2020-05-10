package com.ssm.controller;


import com.ssm.service.ArticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticalController {
    @Autowired
    ArticalService articalService;
}
