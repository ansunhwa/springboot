package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.entity.FoodLog;
import com.study.springboot.repository.FoodLogRepository;

@Service
public class FoodLogService {

    @Autowired
    private FoodLogRepository foodLogRepository;

    public FoodLog addFoodLog(FoodLog foodLog) {
        return foodLogRepository.save(foodLog);
    }
}
