package com.study.spring.search.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
// toString 대신 Serializable 사용
public class Movie implements Serializable {
    private String title;
    private String link;
    private String image;
    private String subtitle;
    private Date pubDate;
    private String director;
    private String actor;
    private float userRating;
}
