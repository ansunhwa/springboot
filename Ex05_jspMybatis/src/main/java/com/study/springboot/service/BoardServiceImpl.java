package com.study.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Board;
import com.study.springboot.repository.BoardDao;

@Service   // 객체로 만드세요
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao boardDao;
	
	@Override
	public List<Board> list() {	
		return boardDao.list();
	}

	@Override
	public int totalRecord() {
		return boardDao.totalRecord();   //dao에서 가지고 옴
	}
	
	@Override
	public Board detailBoard(String boardno) {
		return boardDao.detailBoard(boardno);
	}

	@Override
	public int insertBoard(Board b) {
		
		return 0;
	}

	@Override
	public int deleteBoard(String boardno) {
		
		return 0;
	}

	

}
