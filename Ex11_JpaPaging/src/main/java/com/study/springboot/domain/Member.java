package com.study.springboot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  // 빈 생성자는 사라지고 3개짜리 생김 / jpa는 빈생성자가 있어야 함
@NoArgsConstructor   // jpa쓰려면 빈 생성자도 다시 만들어 줘야함
@Entity(name="jpapaging")
public class Member {
	@Id
	@SequenceGenerator (
			name="pagingseq",
			sequenceName="jpapaging_seq",  //원래이름
			initialValue=1,   //초기값
			allocationSize=1  //1씩증가
			)
	@GeneratedValue(generator = "pagingseq")
	private Long id;
	private String name;
	private String email;
	
}
