package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.CategoryDao;
import com.ssm.pojo.Category;
import com.ssm.service.CategoryService;

@Service
public class CategoryServiceImpl  implements CategoryService{
	@Autowired
	CategoryDao categoryDao;

	public List<Category> listssss(){
		System.out.println("------impl--3213123°¡");
		return categoryDao.list();
	}


}
