package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.study.springboot.domain.Board;
import com.study.springboot.service.BoardService;
import com.study.springboot.service.ReplyService;

@Controller
@SessionAttributes("loginUser")  
// 게시판을 누르면 세션이 사라지기 때문에 세션을 넣어줘야 로그인이 유지된다 / controller이 달라서 끊긴건지 유지인지 구분 안됨
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	ReplyService replyService;   //리플을 추가하려고
	
	
	
	@GetMapping("/list")
	public String list(@RequestParam(value="nowPage", defaultValue="0") int nowPage, Model model) {
		Page<Board> pageList = boardService.list(PageRequest.of(nowPage, 10, Sort.by(Sort.Direction.DESC, "bno"))); 
											//import = domain/ 현재페이지, 한페이지당10개, 가지고올때 내림차순, bno기준
		model.addAttribute("boardPage", pageList);
		//model.addAttribute("board", pageList.getContent());
		
		return "board/list";
	}
	
	@GetMapping("/insertForm")
	public String insertForm() {
		return "board/insertForm";
	}   //insertForm으로 갈 수 있게 호출
	
	
	@PostMapping("/insert")
	public String insert(Board board) {
		boardService.insert(board);
		return "redirect:list";  //전체목록으로
	}
	
	/*
	@GetMapping("/detailForm")
	public String detailForm(@RequestParam("bno") Long bno, Model model) {
		Optional<Board> board = boardService.detail(bno);
		if(board.isPresent()) {
			model.addAttribute("board",board.get());
		} else {
			model.addAttribute("board",null);
		}
		
		//model.addAttribute("board",board);
		return "board/detailForm";
	}
	*/
	
	@GetMapping("/detailForm")
	public String detailForm(@RequestParam("bno") Long bno, Model model) {
	//Board board = boardService.detail(bno).get();
	//List<Reply> reply = replyService.selectAll(bno);  //리플 가지고 옴(bno)기준
	model.addAttribute("board",boardService.detail(bno).get());
	model.addAttribute("reply",replyService.selectAll(bno));
	return  "board/detailForm";
	}
	
	
	
	
	
	

	
	
}
