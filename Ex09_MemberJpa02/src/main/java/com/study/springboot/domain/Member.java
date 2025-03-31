package com.study.springboot.domain;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  // 빈 생성자는 사라지고 3개짜리 생김 / jpa는 빈생성자가 있어야 함
@NoArgsConstructor   // jpa쓰려면 빈 생성자도 다시 만들어 줘야함
@Builder             // 사용할꺼면 넣어주면 됨
@Entity(name="Member Jpa2")
public class Member {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String email;
	
	public Member(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
}
