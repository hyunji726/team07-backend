package com.team7.rabbit.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimerStartRequestDto {

    private Long userId;
    private String contentType;
    private int focusMinutes;
    private int restMinutes;
}