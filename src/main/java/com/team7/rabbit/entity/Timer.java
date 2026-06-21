package com.team7.rabbit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "timers")
public class Timer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 어떤 유저의 타이머인지
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    // 콘텐츠 유형
    @Column(name = "content_type")
    private String contentType;

    // 집중 시간(분)
    @Column(name = "focus_minutes")
    private int focusMinutes;

    // 휴식 시간(분)
    @Column(name = "rest_minutes")
    private int restMinutes;

    // 타이머 시작 여부
    @Column(name = "is_active")
    private boolean isActive;
}