package com.study.springboot.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor  // 빈생성자**
@Entity
@EntityListeners(AuditingEntityListener.class)  //생성, 수정 관리
public class Board {

	@Id
	@SequenceGenerator (
			name="myBoardSEQ",
			sequenceName="Board_SEQ",   //실제 DB만들어지는 이름
			allocationSize=1   //1씩증가
	)
	@GeneratedValue(generator="myBoardSEQ")
	private Long bno;  //pk, 시퀀스, 순서대로
	
	@NonNull  //lombok
	private String title;
	
	@NonNull
	private String content;
	
	@NonNull
	private String writer;
	
	@Column(insertable=false, columnDefinition="NUMBER DEFAULT 0")   //insert안해도 값 안들어 오면 0
	private Long count;  // 숫자는 Long으로 써줌
	
	@CreatedDate   //생성된 날짜
	@Column(name="create_date")
	private LocalDateTime createDate;
	
	@LastModifiedDate  //수정된 날짜
	@Column(name="update_date")  
	private LocalDateTime updateDate;
}
