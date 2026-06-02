package com.team7.rabbit.controller;

import com.team7.rabbit.dto.RewardResponseDto;
import com.team7.rabbit.service.RewardService;
import org.springframework.web.bind.annotation.GetMapping; // 2. 누락된 임포트 추가
import org.springframework.web.bind.annotation.PathVariable; // 2. 누락된 임포트 추가
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users")
public class RewardController {

    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping("/{userId}/rewards")
    public RewardResponseDto getRewards(@PathVariable Long userId) {
        return rewardService.getRewards(userId);
    }
}