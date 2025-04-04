package com.study.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.domain.Board;
import com.study.springboot.repository.BoardRepository;

@RestController
@RequestMapping("/rest")
public class BoardRestController {

	@Autowired
	BoardRepository bRepository;
	
	// http://localhost:8080/rest/boardall
	@GetMapping("/boardall")
	public List<Board> getboardall() {
		return bRepository.findAll();
	}
	
	// http://localhost:8080/rest/board?title=제목2&content=내용2
	  @GetMapping("/board") 
	  public List<Board> getboard(@RequestParam("title") String title,	
				    			  @RequestParam("content")String content) {
	  
		  return bRepository.findByTitleAndContent(title, content);
	  }
	 
	  
	
	@GetMapping("/board/{bno}")
	public Optional<Board> getid(@PathVariable(name="bno") Long bno) {	
		return bRepository.findById(bno).get();
	}
	
	
	
	  
	
	
	
	
}
