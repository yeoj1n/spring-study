package com.study.spring.search.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMovie {
    private List<Item> items;

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Item {
        private String title;
        private String link;
        private String image;
        private String subtitle;
        private Date pubDate;
        private String director;
        private String actor;
        private float userRating;
    }
}
