package com.raphael.hng.hngstagetaskone.service;

import com.raphael.hng.hngstagetaskone.dto.ApiResponse;

public interface ApiService {
    ApiResponse getInfo(String slackName, String track);
}
