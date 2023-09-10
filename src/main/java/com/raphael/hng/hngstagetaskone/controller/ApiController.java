package com.raphael.hng.hngstagetaskone.controller;

import com.raphael.hng.hngstagetaskone.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequiredArgsConstructor
public class ApiController {

    @GetMapping("/api")
    public ResponseEntity<ApiResponse> getInfo(
            @RequestParam("slack_name") String slackName,
            @RequestParam("track") String track
    ) {

        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
        String utc_time = dayFormat.format(new Date());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String current_day = dateFormat.format(new Date());

        String github_file_url = "https://github.com/raphaelekpei/hngTask-1/blob/master/src/main/java/com/raphael/hng/hngstagetaskone/controller/ApiController.java";
        String github_repo_url = "https://github.com/raphaelekpei/hngTask-1";

        ApiResponse apiResponse = new ApiResponse(slackName, track, current_day, utc_time, github_file_url, github_repo_url, HttpStatus.OK.value());
        return ResponseEntity.ok(apiResponse);

    }

}
