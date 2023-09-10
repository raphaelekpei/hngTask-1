package com.raphael.hng.hngstagetaskone.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class ApiResponse {
    private String slack_name;
    private String current_day;
    private String utc_time;
    private String track;
    private String github_file_Url;
    private String github_repo_url;
    private Integer status_code;

}
