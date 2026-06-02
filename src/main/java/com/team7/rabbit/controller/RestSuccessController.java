package com.team7.rabbit.controller;

import com.team7.rabbit.dto.RestSuccessRequestDto;
import com.team7.rabbit.dto.RestSuccessResponseDto;
import com.team7.rabbit.service.RestService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 이제 스프링이 어노테이션으로 잘 인식합니다!
@RequestMapping("/rest")
public class RestSuccessController { // 👈 이름을 이렇게 다르게 찢어주기!

    private final RestService restService;

    public RestSuccessController(RestService restService) {
        this.restService = restService;
    }

    @PostMapping("/success")
    public RestSuccessResponseDto restSuccess(@RequestBody RestSuccessRequestDto request) {
        return restService.restSuccess(request);
    }
}