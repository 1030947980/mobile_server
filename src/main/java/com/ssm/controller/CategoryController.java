package com.ssm.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.pojo.Category;
import com.ssm.service.CategoryService;
import com.ssm.util.Page;

// 告诉spring mvc这是一个控制器类
@RestController
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	/**
	 *
	 * @return
	 */



	@RequestMapping("/listCategory")
	public List<Category> listCategory() {

		System.out.println("------controller--进入服务器");
		List<Category> li= categoryService.listssss();
		System.out.println(li);
		return li;
	}
}
