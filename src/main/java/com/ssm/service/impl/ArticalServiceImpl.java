package com.ssm.service.impl;

import com.ssm.dao.ArticalDao;
import com.ssm.service.ArticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticalServiceImpl implements ArticalService {
    @Autowired
    ArticalDao articalDao;
}
