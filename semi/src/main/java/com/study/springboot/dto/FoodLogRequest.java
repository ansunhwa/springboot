package com.study.springboot.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class FoodLogRequest {
    private String userId;
    private Long foodId;
    private int quantity;
    private int totalCalories;
    private String mealTime;
    private LocalDateTime logDate;
}
