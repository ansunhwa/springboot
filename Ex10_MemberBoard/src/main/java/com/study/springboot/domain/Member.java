package com.study.springboot.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  // 빈 생성자는 사라지고 3개짜리 생김 / jpa는 빈생성자가 있어야 함
@NoArgsConstructor   // jpa쓰려면 빈 생성자도 다시 만들어 줘야함
@Entity(name="Member1")
@EntityListeners(AuditingEntityListener.class)   // 생성, 수정시간 관리**
public class Member {
	@Id
	private String id;
	private String name;
	private String password;
	
	// 엔티티가 생성된 시간
	@CreatedDate    // 엔티티가 생성된 시간 저장
	@Column(name="create_at")
	private LocalDateTime createdAt;
	
	// 엔티티가 수정된 시간
	@LastModifiedDate  // 엔티티가 수정될 때 수정된 시간 저장
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
	
}
