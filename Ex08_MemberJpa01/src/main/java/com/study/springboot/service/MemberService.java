package com.study.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	MemberRepository memberRepository;

	public Member insert(Member member) {
		// save() : jpa에서 insert메소드
		// 			동일한 키(fk)가 있으면 update, 키(fk)가 없으면 insert
		Member result = memberRepository.save(member);
		return result;
	}

	public Optional<Member> select(Long id) {
		
		return memberRepository.findById(id);  //findbyId-> 프라이머리키/ 나는 id인 것만 가져올거
	}

	public List<Member> selectAll() {
		
		return memberRepository.findAll();   //싹 다 찾아주세요
	}

	public void delete(Long id) {
		memberRepository.deleteById(id);
		
	}

	/*
	 * public Member update(Long id, String username) { // TODO Auto-generated
	 * method stub return null; }
	 */

	public Member update(Member member) {
		   //아이디가 있으면 suername, creatDate가 수정이 된다
		return memberRepository.save(member);
	}

	
	//save(member)


	

}
