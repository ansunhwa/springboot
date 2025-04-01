package com.study.springboot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.springboot.domain.Member;

/*
 * JPQL(Java Persistence Query Language)
 *  - JPA 의 Query Methods 만으로 조회가 불가능 할 때
 *    JPQL을 이용하여 SQL과 비슷한 형태의 쿼리를 작성하여 조회
 *    
 * nativeQuery
 *  - 직접 SQL문을 사용하는 방식
 */

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	// JPQL쿼리 : from 뒤에 영속성에 있는 엔티티이름
	// 엔티티이름에 별칭을 넣어주고 
	// 별칭을 이용하여 가지고 올 컬럼과 조건등에 넣는다  m.name  m.id 이런 식으로 조건가져옴
	@Query("select m from jpapaging m where m.name like :name1 order by m.id desc")  //JPQL쿼리 내가 쿼리문 써주면 됨 
	List<Member> findMembers(@Param("name1")String name);   //@Param 앞에서 넘어 온 값을 받겠다

	
	@Query("select m from jpapaging m where m.name like :n1")
	List<Member> findMembers(@Param("n1")String name2, Sort sort);  //알아서 sort가 들어감


	@Query("select m from jpapaging m where m.name like :search")
	Page<Member> findMembers(@Param("search")String name, Pageable pageable);

	
	//일반 sql문
	@Query(value="select * from jpapaging where name like :name1 order by id desc",
			nativeQuery = true)
	List<Member> findMembersNative(@Param("name1")String name);   //@param에 들어있는 거 넣어주는건 같음

	
	//jpapaging
	
	
	
}
