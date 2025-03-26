package com.study.springboot.service;

import java.util.List;

import com.study.springboot.domain.Board;
//구현체에 어노테이션 줄거라서 안줘도 됨
public interface BoardService {
	public List<Board> list();        //list목록 가지고 오기
	public int totalRecord();
	public Board detailBoard(String boardno);
	public int insertBoard(Board b);   //사용자가 넣은거 Board(b)에 담아서 가져올거
	public int deleteBoard(String boardno);  // 지울수도
	
}
