package com.raphael.hng.hngstagetaskone.controller;

import com.raphael.hng.hngstagetaskone.dto.ApiResponse;
import com.raphael.hng.hngstagetaskone.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final ApiService apiService;

    @GetMapping("/api")
    public ResponseEntity<ApiResponse> getInfo(
            @RequestParam("slack_name") String slackName,
            @RequestParam("track") String track
    ){
        ApiResponse apiResponse = apiService.getInfo(slackName, track);
        return ResponseEntity.ok(apiResponse);

    }
}
