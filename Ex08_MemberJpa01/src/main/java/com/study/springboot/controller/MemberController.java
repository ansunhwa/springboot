package com.study.springboot.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		return "menu";
	}
	
	@RequestMapping("/insert")
	/*
	 * Member member2 = new Member();  //아이디(fk)를 제외함
	 * member2.setUsername(name);
	 * member2.setCreateDate(LocalDate.now());
	 */
	public String insert(@RequestParam("username") String name, Model model) {   //앞 값, 뒤 변수에 저장
		Member member = Member.builder()
							.username(name)
							.createDate(LocalDate.now())
							.build();	
		
		Member result = memberService.insert(member);
		
		model.addAttribute("member",result);
		return "insert";
	}
	
	@RequestMapping("/select")
	public String select(@RequestParam("id")Long id, Model model) {   //id가져올꺼고  Long타입의 id, 
		/*
		 *  Optional<T> : NullpointerException 발생을 방지하기 위해
		 *  			  기존의 반환 값 타입 T에 Optional<T>를 wrapping하여,
		 *  			  null 대신 Optional안에 빈 타입 객체를 돌려주는 기법
		 *  ex) Member member = memberRepository.findById("user01");  user01인거 갖고오세요 => 없는아이디
		 *  	member.getUserName(); => nullpointerException발생(비어있기 때문에)
		 *  	들어있지 않으면 비어있는 타입, 들어있으면 보여줄 수 있게  Member를 한번 감싼거임 가지고 올땐 다시 풀어줘야함
		 */
		Optional<Member> result = memberService.select(id);   //자바유틸
		if(result.isPresent()) { // isPresent() : 데이터가 있는지 없는지 체크 
			model.addAttribute("member",result.get());   //가지고 올땐 다시 풀어줘야함 .get()
			
		} else {
			model.addAttribute("member", null);
		}
		
		return "select";
	}
	
	@RequestMapping("/selectAll")
	public String selectAll(Model model) {  //넘겨 줄 값X 넘어와야 하는 값O -> Model
		List<Member> result = memberService.selectAll();  // 이거하고 repository설정
		model.addAttribute("members", result); // 값받아오기
		return "selectAll";		
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		memberService.delete(id);	
		return "menu";
	}
	
	
	/*
	 * @RequestMapping("/update") 
	 * public Member update(@RequestParam("id") Long id,
	 * 						@RequestParam("username") String username,
	 * 						Model model) { 
	 * Member upeate =
	 * memberService.update(id, username);
	 * 
	 * }
	 */
	
	@RequestMapping("/update")
	public String update(Member member, Model model) {
		// update시 primary key를 검색하여 키가 있으면 다른 필드 모두 업데이트
		// update시 기존내용을 업데이트 하지 않는다고 안넣으면 null이 들어감
		// => select를 하여 그 결과에 update할 내용만 넣으면 됨
		member.setCreateDate(LocalDate.now());
		Member result = memberService.update(member);
		model.addAttribute("member", result);
		return "update";
						
	}
	
	/*
	 * delete후 menu로 가기

	 * update의 반환형은 member
	 *      update후 update.jsp로 가기
	 */
	
	
	
}
