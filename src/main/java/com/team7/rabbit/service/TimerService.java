package com.team7.rabbit.service;

import com.team7.rabbit.dto.TimerStartRequestDto;
import com.team7.rabbit.entity.Timer;
import com.team7.rabbit.entity.User;
import com.team7.rabbit.repository.TimerRepository;
import com.team7.rabbit.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class TimerService {

    private final TimerRepository timerRepository;
    private final UserRepository userRepository;

    public TimerService(
            TimerRepository timerRepository,
            UserRepository userRepository) {

        this.timerRepository = timerRepository;
        this.userRepository = userRepository;
    }

    public Timer startTimer(TimerStartRequestDto request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new IllegalArgumentException("유저를 찾을 수 없습니다."));

        Timer timer = new Timer();

        timer.setUser(user);
        timer.setContentType(request.getContentType());
        timer.setFocusMinutes(request.getFocusMinutes());
        timer.setRestMinutes(request.getRestMinutes());
        timer.setActive(true);

        return timerRepository.save(timer);
    }
}