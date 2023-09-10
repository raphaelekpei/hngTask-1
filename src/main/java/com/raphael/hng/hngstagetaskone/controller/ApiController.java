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
import java.util.TimeZone;

@RestController
@RequiredArgsConstructor
public class ApiController {

    @GetMapping("/api")
    public ResponseEntity<ApiResponse> getInfo(
            @RequestParam("slack_name") String slackName,
            @RequestParam("track") String track
    ) {
        String github_file_url = "https://github.com/raphaelekpei/hngTask-1/blob/master/src/main/java/com/raphael/hng/hngstagetaskone/controller/ApiController.java";
        String github_repo_url = "https://github.com/raphaelekpei/hngTask-1";

        String currentDay = getCurrentDayOfWeek();

        String utcTime = getCurrentUTCDateTime();

        ApiResponse apiResponse = ApiResponse
                .builder()
                .slack_name(slackName)
                .current_day(currentDay)
                .utc_time(utcTime)
                .track(track)
                .github_file_Url(github_file_url)
                .github_repo_url(github_repo_url)
                .status_code(HttpStatus.OK.value())
                .build();

        return ResponseEntity.ok(apiResponse);

    }

    private String getCurrentDayOfWeek() {
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
        dayFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dayFormat.format(new Date());
    }

    private String getCurrentUTCDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat.format(new Date());

    }

}
