package com.team7.rabbit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users") // ★ USER 예약어를 피하기 위해 테이블 이름을 'users'로 강제 지정!
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_carrots")
    private int totalCarrots;

    @Column(name = "rabbit_state")
    private String rabbitState;
    @Column(name = "success_count")
    private int successCount;

    @Column(name = "fail_count")
    private int failCount;

    @Column(name = "continuous_streak")
    private int continuousStreak;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "user")
    private List<Timer> timers;
}

