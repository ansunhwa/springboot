package com.study.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor 
public class Test1 {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String content;
	private java.time.LocalDateTime create_at;
	private int check;

}
