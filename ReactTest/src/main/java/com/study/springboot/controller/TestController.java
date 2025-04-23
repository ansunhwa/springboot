package com.study.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")  //자바는 '',"" 구분
public class TestController {
	
	@GetMapping("/test")
	public String hello() {
		return "hello 테스트 입니다";
	}
}
