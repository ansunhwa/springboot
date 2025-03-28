package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	// 만들어 놔 주면 알아서 해줌
}
