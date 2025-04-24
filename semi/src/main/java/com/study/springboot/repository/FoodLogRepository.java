package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.study.springboot.entity.FoodLog;

public interface FoodLogRepository extends JpaRepository<FoodLog, Long> {
}
