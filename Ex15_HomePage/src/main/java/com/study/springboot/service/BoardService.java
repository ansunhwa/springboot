package com.study.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Board;
import com.study.springboot.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	BoardRepository boardRepository;

	public Page<Board> list(PageRequest of) {
		return boardRepository.findAll(of);
	}

	public void insert(Board board) {
		 boardRepository.save(board);   //반환X 넣기만
		
	}

	/*
	public Optional<Board> detail(Long bno) {
		
		return boardRepository.findById(bno);
	}
	*/
	
	public Optional<Board> detail(Long bno) {
		return boardRepository.findById(bno)
								.map(board -> {
								board.setCount(board.getCount() +1);
								return boardRepository.save(board);
								});
		
		
		
		
	}
	
	

}
