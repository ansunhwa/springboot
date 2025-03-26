package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@RequestMapping("/")                    // 아무것도 안넣으면 기본 localhost8080실행
	public @ResponseBody String root() {   //root를 열면 return이 실행   @ResponseBody String => 일반 스트링
		return "JSP실행";
	}
	
	@GetMapping("/test1")       // ****localhost8080/test1 실행 
	public String test1() {      //String => 파일명  이름은 아무거나 해도 됨 
		return "test1";        // **** 호출할 페이지 : /WEB-INF/views/test1.jsp    properties에서 설정한 대로 들어감
	} 
	
	@RequestMapping("/test2")
	public String test2() {
		return "sub/test2";        // /WEB-INF/views/sub/test2.jsp 
	} 
	

}




