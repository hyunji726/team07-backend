package com.team7.rabbit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@AllArgsConstructor
public class RewardResponseDto {

    @JsonProperty("total_carrots")
    private int totalCarrots;

    @JsonProperty("has_background")
    private boolean hasBackground;

    @JsonProperty("has_ribbon")
    private boolean hasRibbon;

    @JsonProperty("has_special_bg")
    private boolean hasSpecialBg;
}