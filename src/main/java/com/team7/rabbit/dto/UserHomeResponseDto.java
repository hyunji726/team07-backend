UserHomeResponseDto.javapackage com.team7.rabbit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserHomeResponseDto {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("total_carrots")
    private int totalCarrots;

    @JsonProperty("rabbit_state")
    private String rabbitState;

    // --- 생성자 (Service에서 데이터를 채워줄 때 사용) ---
    public UserHomeResponseDto(Long userId, int totalCarrots, String rabbitState) {
        this.userId = userId;
        this.totalCarrots = totalCarrots;
        this.rabbitState = rabbitState;
    }

    // --- Getter (스프링이 JSON으로 변환할 때 사용) ---
    public Long getUserId() {
        return userId;
    }

    public int getTotalCarrots() {
        return totalCarrots;
    }

    public String getRabbitState() {
        return rabbitState;
    }
}