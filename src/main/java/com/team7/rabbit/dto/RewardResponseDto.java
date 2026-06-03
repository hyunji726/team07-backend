package com.team7.rabbit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@AllArgsConstructor
public class RewardResponseDto {

    @JsonProperty("total_carrots")
    private int totalCarrots;

    @JsonProperty("yellow_ribbon")
    private boolean yellowRibbon;

    @JsonProperty("pink_ribbon")
    private boolean pinkRibbon;

    @JsonProperty("blue_ribbon")
    private boolean blueRibbon;

    @JsonProperty("field_background")
    private boolean fieldBackground;

    @JsonProperty("sunset_background")
    private boolean sunsetBackground;

    @JsonProperty("night_background")
    private boolean nightBackground;

    @JsonProperty("cherry_blossom_background")
    private boolean cherryBlossomBackground;
}