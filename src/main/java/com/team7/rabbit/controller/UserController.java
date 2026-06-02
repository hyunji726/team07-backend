package com.team7.rabbit.controller;

import com.team7.rabbit.dto.UserHomeResponseDto;
import com.team7.rabbit.dto.StatisticsResponseDto; // 1. 통계 DTO 임포트 추가!
import com.team7.rabbit.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // --- 홈 화면 메인 데이터 조회 ---
    @GetMapping("/users/{userId}/home")
    public UserHomeResponseDto getUserHomeData(@PathVariable("userId") Long userId) {
        return userService.getUserHomeData(userId);
    }
}