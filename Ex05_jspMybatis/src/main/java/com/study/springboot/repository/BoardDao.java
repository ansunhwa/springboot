package com.study.springboot.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot.domain.Board;

/*
 * @Mapper : MyBatis의 Mapper interface임을 나타내줌
 * 			MyBatis의 xml 에 있는 sql쿼리와 매핑을 자동으로 해줌
 */
@Mapper    
public interface BoardDao {
		
	public List<Board> list();        //list목록 가지고 오기	
	public int totalRecord();
	
	public Board detailBoard(String boardno);
	
	public int insertBoard(Board b);   //사용자가 넣은거 Board(b)에 담아서 가져올거
	public int deleteBoard(String boardno);  // 지울수도
	
	
	
	

}
