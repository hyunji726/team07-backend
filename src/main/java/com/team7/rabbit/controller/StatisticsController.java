package com.team7.rabbit.controller;

import com.team7.rabbit.dto.StatisticsResponseDto;
import com.team7.rabbit.service.StatisticsService;
import org.springframework.web.bind.annotation.GetMapping; // 2. 누락된 임포트 추가
import org.springframework.web.bind.annotation.PathVariable; // 2. 누락된 임포트 추가
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users")
public class StatisticsController {

    private final StatisticsService statisticsService;

    public StatisticsController(
            StatisticsService statisticsService
    ) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/{userId}/stats")
    public StatisticsResponseDto getStatistics(
            @PathVariable Long userId
    ) {
        return statisticsService.getStatistics(userId);
    }
}