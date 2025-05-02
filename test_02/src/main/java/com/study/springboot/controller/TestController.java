package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.service.TestService;

@Controller
public class TestController {
	@Autowired
	TestService testService;
	
	@RequestMapping("/")
	public String testAdd() {
		
	}
	

}
