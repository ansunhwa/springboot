package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.domain.Member;
import com.study.springboot.dto.ResponseDto;
import com.study.springboot.dto.UserDto;
import com.study.springboot.service.MemberRestService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/rest")
public class MemberRestController {
	@Autowired
	MemberRestService memberRestService;

	// http://localhost:8080/rest/test
	@GetMapping("/test") // /rest/test
	public String test() {
		log.info("test");
		return "test입니다";
	}

	// http://localhost:8080/rest/user
	// http://localhost:8080/rest/user?id=10
	@GetMapping("/user")
	public String getMamber(@RequestParam(value = "id", defaultValue = "1") String id) {
		log.info("id : ", id);
		return "ok : " + id;
	}

	// http://localhost:8080/rest/user/10 -> restful
	@GetMapping("/user/{id}")
	public String getid(@PathVariable("id") String id) {
		log.info("id : ", id);
		return "ok : " + id;
	}

	// http://localhost:8080/swagger-ui.html ->내가 했던 과정들 나옴
	/*
	 * @PostMapping("/userdto") public UserDto saveUserDto(@RequestBody UserDto
	 * userDto) {
	 * 
	 * Member m = memberRestService.saveUserDto(userDto); // Dto 한 행이 m 에 들어옴
	 * 
	 * UserDto uDto = new UserDto(m); //bean의 m호출됨
	 * 
	 * // UserDto uDto = new UserDto(memberRestService.saveUserDto(userDto)); - 한줄로
	 * 
	 * return uDto;
	 * 
	 * return new UserDto(memberRestService.saveUserDto(userDto)); //- 전체를 한줄로
	 * 
	 * }
	 */

	// http://localhost:8080/rest/userdto
	@PostMapping("/userdto")
	public ResponseDto saveUserDto(@RequestBody UserDto userDto) {
		Member m = memberRestService.saveUserDto(userDto);
		
		ResponseDto responseDto = new ResponseDto();
		
		if(m.getId() != null) {
			responseDto.setMessage("ok");
			return responseDto;
		} else {
			responseDto.setMessage("fail");
			return responseDto;
		}		
	}	
	
	// http://localhost:8080/rest/userdto?
	@GetMapping("/userdto")  //id?
	public UserDto getUser(@RequestParam("id") String id ) {
		log.info("id : " , id);
		
		return memberRestService.getUserById(id);
	}
	
	// http://localhost:8080/rest/userdto/user01
	@GetMapping("/userdto/{id}")  
	public UserDto getUserDto(@PathVariable("id") String id ) {
		log.info("id : " , id);
		
		return memberRestService.getUserById(id);
	}
	
	// http://localhost:8080/rest/userall
	@GetMapping("/userall")
	public List<Member> getUserAll() {
		return memberRestService.getUserAll();
	}
	
	@GetMapping("/userdtoall")
	public List<UserDto> getUserDtoAll() {
		return memberRestService.getUserDtoAll();
	}
	
	
	
	
	
}
