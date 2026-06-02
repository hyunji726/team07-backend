package com.team7.rabbit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestSuccessRequestDto {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("timer_id")
    private Long timerId;

    @JsonProperty("is_correct")
    private boolean isCorrect; // 맞췄으면 true, 틀렸으면 false!
}