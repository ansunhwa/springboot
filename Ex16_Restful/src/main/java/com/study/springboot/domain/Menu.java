package com.study.springboot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Menu {
	@Id
	@SequenceGenerator (
			name="myMenuSEQ",
			sequenceName="Menu_SEQ",   //실제 DB만들어지는 이름
			allocationSize=1   //1씩증가
	)
	@GeneratedValue(generator="myMenuSEQ")
	private Long id;
	
	private String restaurant; // 음식점
	private String name;       // 메뉴명
	private Long price;        // 가격
	
	
	@Enumerated(EnumType.STRING)
	private Type type;         // 한식KR 중식CH 일식JP
	
	@Enumerated(EnumType.STRING)
	private Taste taste;		// 순한맛MILD, 매운맛HOT
	
	
}
