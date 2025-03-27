package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.domain.Board;
import com.study.springboot.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
	
	@Autowired  //
	BoardService boardService;
	
	@RequestMapping("/")
	public String root() {
		return "redirect:list";  // /list 가 호출됨
	}
	
	/*
	 * 요청 처리 후 응답페이지로 포워딩 또는 url재요청시 응답데이터를 담는 방법
	   1. Model객체
	  	  포워딩할 뷰로 전달하고자 하는 데이터를 맵형식<key-value>로 담을 수 있다
	  	  requestScope임.
	  	  *** 단, setAttribute가 아닌 addAttribute메소드를 이용
	  	  
	   2. ModelAndView객체
	      Medel은 데이터를 맵형식<key-value>으로 담고,
	      View는 응답뷰에 대한 정보를 담을 수 있는 공간 (return 사용안함)
	 */
	
	@RequestMapping("/list")
	public String listPage(Model model) {
		List<Board> list = boardService.list();
		int record = boardService.totalRecord();
		
		model.addAttribute("list", list);                  //add한 값을 가지고 list로 간다
		model.addAttribute("totalRecord", record);
		return "list";
	}
	
	/*
	 * 요청시 전달한 값(파라미터)를 받는 방법
	   1. HttpServletRequest를 이용한 방법
	     : 메서드의 매개변수에 넣는 방법
	     ex)
	     @GetMapping("/detail")
	     public String detailView(HttpServletRequest request) {
	     	int bno = request.getParmeter("boardno");     // 자동형변환
	     }
	   
	   2. @RequestParma 어노테이션을 사용하는 방법
	   	  : 메서드 위에 어노테이션을 넣는 방법
	   	    - 변수에 저장할 때 : request.getParmeter("키")
	   	  ex)
	   	  
	   	  detail?boardno=1
	   	  
	   	  @GetMapping("/detail")
	   	   public String detailView(@RequestParam(value="boardno") int bno,
	   	   							@RequestParam(value="writer", defaultValue="홍길동") String user){
	   	   				Board board = boardService.detailboard(bno);
	   	  }
	   	  
	   3. 매개변수명으로 사용하는 방법
	   	  : 매개변수명 name값(요청시전달값의 키)과 동일하게 세팅해줘야 자동으로 같이 주입됨
	   	  ex)
	   	  @GetMapping("/detail")
	   	  public String detailView(int boardno) {
	   	  	//앞에서 넘어온 값과 같은 이름 해야함
	   	  }
	   	  
	   
	   4. @ModelAttribute 어노테이션을 사용하는 방법
	   	  : 주로 객체를 받을 때 사용
	   	  요청시 전달값의 키값(name값)을 bean 클래스에 담고자 하는 필드명으로 작성
	   	  **** 반드시 name과 담고자 하는 필드명이 동일해야 한다**
	   	  ex)
	   	  @GetMapping("/detail")
	   	  public String detailView(@ModelAttribute("form") Board b) {
	   	  	String title = b.getTitle();
	   	  	b.setWriter = "김땡땡";
	   	  		form에  값 넣어줄때 <input name="title">, <input name="writer">
	   	  }
	   
	   5. 커맨드 객체 방식
	     : 객체를 받을 때 사용
	      ex)
	   	  @GetMapping("/detail")
	   	  public String detailView(Board b) {
	   	  	String title = b.getTitle();
	   	  	b.setWriter = "김땡땡";
	   	  }
	     
	   
	   
	 * 
	 */
	
	@GetMapping("/detail")
	public String detailView(HttpServletRequest request, Model model) {
		String boardno = request.getParameter("boardno");
		
		//Board board = boardService.detailBoard(boardno);
		//model.addAttribute("board", board);
		model.addAttribute("board", boardService.detailBoard(boardno));
		return "detail";
	}
	
	@GetMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@PostMapping("/write")
	public String write(Board b) {
		boardService.insertBoard(b);
		return "redirect:list";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		String bno = request.getParameter("boardno");
		boardService.deleteBoard(bno);
		return " redirect:list";
	}
	
	
	
	
	
}
