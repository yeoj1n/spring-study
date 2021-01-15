package com.study.spring.search.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieGroup {
    private List<Movie> movieList;

    public List<Movie> getListOrderRating() {
        return movieList.stream()
                .filter(m -> !((Float)m.getUserRating()).equals(0.0f))
                .sorted(Comparator.comparing(Movie::getUserRating).reversed())
                .collect(Collectors.toList());
    }
}
