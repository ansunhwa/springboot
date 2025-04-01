package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Jarscontroller {
	
	@RequestMapping("/")
	public String root() {
		return "main";
	}

}
