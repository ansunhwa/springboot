package com.study.springboot.dto;

import com.study.springboot.domain.Member;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor    //반드시 빈 생성자 있어야 함 값을 넣으면 없어지니까 꼭 확인하고 만들기
public class UserDto {
	private String id;
	private String name;
		
	public UserDto(Member m) {   //Member에서 가지고 옴
		this.id = m.getId();
		this.name = m.getName();
	}

}
