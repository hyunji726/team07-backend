package com.team7.rabbit.controller;

import com.team7.rabbit.dto.TimerStartRequestDto;
import com.team7.rabbit.entity.Timer;
import com.team7.rabbit.service.TimerService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TimerController {

    private final TimerService timerService;

    public TimerController(TimerService timerService) {
        this.timerService = timerService;
    }

    @PostMapping("/timer/start")
    public Timer startTimer(
            @RequestBody TimerStartRequestDto request) {

        return timerService.startTimer(request);
    }
}