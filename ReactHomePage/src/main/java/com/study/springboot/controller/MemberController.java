package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

@Controller
@SessionAttributes("loginUser")
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@Autowired
	PasswordEncoder pEncoder;  //Bean으로 만들었기 때문에 여기서 사용
	
	
	 //@Autowired HttpSession session;
	 
	
	//controller중에서 루트매핑은 한곳에만
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("/enrollForm")
	public String enrollForm() {
		return "member/enrollForm";
	}
	
	@GetMapping("/idCheck")  //@ResponseBody <- 요 사이에 넣어줘도 돼
	public @ResponseBody boolean idCheck(@RequestParam("id") String id) {  //@ResponseBody 반환해줘야 하기 때문에
		return memberService.idCheck(id);  //true면 아이디 ㅇ false면 X
	}
	
	@PostMapping("/memberInsert")
	public String insert(Member member) {
		String enPass = pEncoder.encode(member.getPassword());   //비밀번호 암호화
		member.setPassword(enPass);
		
		memberService.insert(member);
		return "redirect:/";  //다시 index(root)로 가세요
	}
	
	/*
	 *  로그인 시 password
	 *  pEncode.matches(사용자가 넣은 패스워드, DB에서 가져온 패스워드
	 */
	
	@PostMapping("/login")
	public String login(Member member, Model model) {  //@RequestParam으로 받아도 됨(아이디, 비번)
		Member loginUser = memberService.login(member);
		if(loginUser != null && pEncoder.matches(member.getPassword(), loginUser.getPassword())) {
			model.addAttribute("loginUser",loginUser);  
			//리퀘스트스코프 세션 다른데서 사용X  -> session scope로 변환해야함 (@SessionAttribute({"loginUser", "여러개"})) 여러개면 중괄호
		}
		return "redirect:/";
	}
	
	/*
	 *  @SessionAttributes + model을 통해 로그인 정보를 관리하는 경우
	 *    SessionStatus객체를 통해 사용완료 처리를 해야 함.
	 *    - session객체를 폐기하지 않고 재사용
	 */
	
	@GetMapping("/logout")  //session을 끊어주면 됨
	public String logout(SessionStatus status) {
		if(!status.isComplete()) {   //Complete이 되어있으면, 쓰고 있다면
			status.setComplete();  // 사용완료
		}
		return "redirect:/";
	}

	

	
	
	

}
