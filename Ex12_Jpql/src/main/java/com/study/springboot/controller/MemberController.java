package com.study.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("/selectNameLike1")
	public String selectNameLike1(@RequestParam("name")String search, Model model ) {
		String name = search + "%";
		
		List<Member> result = memberService.selectNameLike1(name);
		model.addAttribute("members", result);
		return "selectNameList1";
	}
	
	@GetMapping("/selectNameLike2")  //Sort
	public String selectNameLike2(@RequestParam("name")String search, Model model ) {
		String name = search + "%";
		Sort sort = Sort.by(Sort.Order.asc("id"));  // id의 오름차순
		
		List<Member> result = memberService.selectNameLike2(name, sort);
		
		model.addAttribute("members", result);
		
		return "selectNameList1";
	}
	
	@GetMapping("/selectNameLike3")
	public String selectNameLike3(@RequestParam("name")String search, 
			@RequestParam("page")int page,
			Model model ) {
		String name = search + "%";
		Sort sort = Sort.by(Sort.Order.desc("id"));
		Pageable pageable = PageRequest.of(page-1, 10, sort);
		
		Page<Member> result = memberService.selectNameLike3(name, pageable);  //페이지로 담아야 함 Pageable
		
		List<Member> member = result.getContent();  //10개의 행이 들어있음
		long totalRecored = result.getTotalElements();  //게시글갯수
		int totalPage = result.getTotalPages();        //페이지수

		model.addAttribute("members", member);
		model.addAttribute("totalRecored",totalRecored);
		model.addAttribute("totalPage", totalPage);
		
		
		return "selectNameList2";
	}
	
	@GetMapping("/selectNameLike4")
	public String selectNameLike4(@RequestParam("name")String search, Model model ) {
		String name = search + "%";
		
		List<Member> result = memberService.selectNameLike4(name);
		
		model.addAttribute("members", result);
		return "selectNameList1";
	}
	

	
	
	
}
