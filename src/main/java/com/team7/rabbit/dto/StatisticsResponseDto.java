package com.team7.rabbit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@AllArgsConstructor
public class StatisticsResponseDto {

    @JsonProperty("success_rate")
    private double successRate;

    @JsonProperty("success_count")
    private int successCount;

    @JsonProperty("fail_count")
    private int failCount;

    @JsonProperty("continuous_streak")
    private int continuousStreak;

    @JsonProperty("total_carrots")
    private int totalCarrots;
}
