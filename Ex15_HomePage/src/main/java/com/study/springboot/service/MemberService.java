package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository memberRepository;

	public boolean idCheck(String id) {
		return memberRepository.existsById(id);
	}

	public Member insert(Member member) {
		return memberRepository.save(member);
	}
	
	

}
