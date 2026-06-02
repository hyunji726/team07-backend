package com.team7.rabbit.service;

import com.team7.rabbit.dto.RestSuccessRequestDto;
import com.team7.rabbit.dto.RestSuccessResponseDto;
import com.team7.rabbit.entity.User;
import com.team7.rabbit.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RestService {

    private final UserRepository userRepository;

    public RestService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional // DB 값을 수정할 때는 붙여주는 것이 안전합니다!
    public RestSuccessResponseDto restSuccess(RestSuccessRequestDto request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("유저 없음"));

        // 🔥 [여기서 분기!] 맞췄을 때와 틀렸을 때의 처리를 찢어줍니다.
        if (request.isCorrect()) {
            // 당근 +1
            user.setTotalCarrots(user.getTotalCarrots() + 1);

            // 성공횟수 +1
            user.setSuccessCount(user.getSuccessCount() + 1);

            // 연속성공 +1
            user.setContinuousStreak(user.getContinuousStreak() + 1);
        } else {
            // ❌ 틀렸을 때는 당근을 주지 않고, 실패 횟수만 올립니다!
            user.setFailCount(user.getFailCount() + 1);

            // 연속 성공 기록은 아쉽지만 0으로 깨집니다.
            user.setContinuousStreak(0);
        }

        // 성공률 계산 (기본값을 0으로 잡고, 반올림 로직 추가!)
        int success = user.getSuccessCount();
        int fail = user.getFailCount();

        double successRate = 0;

        if (success + fail > 0) {
            double rawRate = ((double) success / (success + fail)) * 100;
            // 86.6666... -> 86.7 소수점 첫째 자리 반올림
            successRate = Math.round(rawRate * 10.0) / 10.0;
        }

        // 토끼 상태 변경 (소수점 정리된 successRate로 판단)
        if (successRate >= 70) {
            user.setRabbitState("HEALTHY");
        } else if (successRate >= 40) {
            user.setRabbitState("TIRED");
        } else {
            user.setRabbitState("EXHAUSTED");
        }

        userRepository.save(user);

        // 결과에 따라 응답 메시지도 "SUCCESS" 또는 "FAIL"로 동적으로 내려주면 프론트가 좋아합니다!
        String resultStatus = request.isCorrect() ? "SUCCESS" : "FAIL";

        return new RestSuccessResponseDto(
                resultStatus,
                1,
                user.getTotalCarrots(),
                user.getRabbitState()
        );
    }
}