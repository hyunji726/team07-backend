package com.team7.rabbit.service;

import com.team7.rabbit.dto.RewardResponseDto;
import com.team7.rabbit.entity.User;
import com.team7.rabbit.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RewardService {

    private final UserRepository userRepository;

    public RewardService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RewardResponseDto getRewards(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("유저 없음"));

        int carrots = user.getTotalCarrots();

        return new RewardResponseDto(
                carrots,
                carrots >= 10,
                carrots >= 20,
                carrots >= 30
        );
    }
}