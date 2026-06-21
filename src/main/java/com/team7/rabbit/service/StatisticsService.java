package com.team7.rabbit.service;

import com.team7.rabbit.dto.StatisticsResponseDto;
import com.team7.rabbit.entity.User;
import com.team7.rabbit.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private final UserRepository userRepository;

    public StatisticsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public StatisticsResponseDto getStatistics(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("유저 없음"));

        int success = user.getSuccessCount();
        int fail = user.getFailCount();

        double successRate = 0;

        if(success + fail > 0){
            double rawRate = ((double) success / (success + fail)) * 100;

            // 소수점 둘째 자리에서 반올림하여 첫째 자리까지 남기기 (86.666... -> 86.7)
            successRate = Math.round(rawRate * 10.0) / 10.0;
        }

        return new StatisticsResponseDto(
                successRate,
                success,
                fail,
                user.getContinuousStreak(),
                user.getTotalCarrots()
        );
    }
}
