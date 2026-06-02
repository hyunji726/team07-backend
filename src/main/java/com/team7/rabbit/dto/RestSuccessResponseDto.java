package com.team7.rabbit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestSuccessResponseDto {

    private String result;

    @JsonProperty("added_carrot")
    private int addedCarrot;

    @JsonProperty("total_carrots")
    private int totalCarrots;

    @JsonProperty("rabbit_state")
    private String rabbitState;
}