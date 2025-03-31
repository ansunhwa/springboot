package com.study.springboot.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;


@Service
public class MemberService {
	@Autowired
	MemberRepository memberRepository;

	public void insert() {
		Member member;
		member = new Member("더조은", "test@test.com");
		memberRepository.save(member);
		
		member = new Member("김파랑", "test2@test.com");
		memberRepository.save(member);
		
		member = new Member("최노랑", "test3@test.com");
		memberRepository.save(member);
		
		member = new Member("이분홍 ", "test4@test.com");
		memberRepository.save(member);
		
		member = new Member("박초록", "tes5t@test.com");
		memberRepository.save(member);
		
		member = new Member("김검정", "tes6t@test.com") ;
		memberRepository.save(member);
		
		member = new Member("홍연두", "test7@test.com") ;
		memberRepository.save(member);
		
		
	}

	public List<Member> selectAll() {
		return memberRepository.findAll();
	}

	public Optional<Member> select(Long id) {
		return memberRepository.findById(id);
	}

	public Optional<Member> selectByName(String name) {
		return memberRepository.findByName(name);   
		//findBy 까지만 뜸 내가 name으로 할꺼여서 name을 적어줌 근데 얘는 만들어져 있는게 아니여서 만들어야함
		//MemberRepository 여기에 만들어줌
	}

	public Optional<Member> selectByEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	public List<Member> selectByNameLike(String name2) {

		return memberRepository.findByNameLike(name2);
	}

	public List<Member> selectByNameLikeNameDesc(String name2) {

		//return memberRepository.findByNameLikeOrderByName(name2); //이름의 오름차순 정렬 첫글자는 대문자
		return memberRepository.findByNameLikeOrderByNameDesc(name2); //내림차순 정렬
	}

	public List<Member> selectByNameLikeSort(String name2, Sort sort) {
		return memberRepository.findByNameLike(name2, sort);
	}
	
	
	

}
