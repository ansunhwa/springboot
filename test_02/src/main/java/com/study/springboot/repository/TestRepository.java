package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.entity.Test1;

@Repository
public interface TestRepository extends JpaRepository<Test1, Long> {

}
