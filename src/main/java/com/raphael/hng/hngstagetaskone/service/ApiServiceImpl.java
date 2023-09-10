package com.raphael.hng.hngstagetaskone.service;



import com.raphael.hng.hngstagetaskone.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


@Service
public class ApiServiceImpl implements ApiService {
    @Override
    public ApiResponse getInfo(String slackName, String track) {

        String currentDay = getCurrentDayOfWeek();

        String utcTime = getCurrentUTCDateTime();

        String githubFileUrl = "https://github.com/raphaelekpei/hngTask-1/blob/master/src/main/java/com/raphael/hng/hngstagetaskone/controller/ApiController.java";
        String githubRepoUrl = "https://github.com/raphaelekpei/hngTask-1";

        return ApiResponse
                .builder()
                .slack_name(slackName)
                .current_day(currentDay)
                .utc_time(utcTime)
                .track(track)
                .github_file_Url(githubFileUrl)
                .github_repo_url(githubRepoUrl)
                .status_code(HttpStatus.OK.value())
                .build();
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
