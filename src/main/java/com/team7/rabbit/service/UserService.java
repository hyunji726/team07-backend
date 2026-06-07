package com.team7.rabbit.service;

import com.team7.rabbit.dto.UserHomeResponseDto;
import com.team7.rabbit.dto.StatisticsResponseDto;
import com.team7.rabbit.entity.User;
import com.team7.rabbit.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service // 여기가 핵심 비즈니스 로직이 들어가는 곳이야 라고 알려주는 이름표
public class UserService {

    private final UserRepository userRepository;

    // --- 생성자 주입 (스프링이 Repository를 서비스에 쏙 끼워 넣어 줍니다) ---
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // --- 홈 화면 메인 데이터 조회 로직 ---
    public UserHomeResponseDto getUserHomeData(Long userId) {

        // 1. Repository를 통해 DB에서 해당 user_id를 가진 유저를 찾습니다.
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다. id: " + userId));

        // 2. DB에서 꺼내온 유저 정보를 DTO에 담아서 반환합니다.
        return new UserHomeResponseDto(
                user.getId(),
                user.getTotalCarrots(),
                user.getRabbitState()
        );
    }
    public User createUser(String username) {

        User user = new User();

        user.setUsername(username);
        user.setTotalCarrots(0);
        user.setRabbitState("HEALTHY");
        user.setSuccessCount(0);
        user.setFailCount(0);
        user.setContinuousStreak(0);

        return userRepository.save(user);
    }

    public User updateUserName(Long userId, String username) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new IllegalArgumentException("해당 유저를 찾을 수 없습니다."));

        user.setUsername(username);

        return userRepository.save(user);
    }

    public User skipRest(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new IllegalArgumentException("유저를 찾을 수 없습니다."));

        user.setFailCount(user.getFailCount() + 1);

        if (user.getFailCount() >= 10) {
            user.setRabbitState("EXHAUSTED");
        } else if (user.getFailCount() >= 5) {
            user.setRabbitState("TIRED");
        }

        return userRepository.save(user);
    }
}