package com.study.spring.search.repository;

import com.study.spring.search.dto.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> findByQuery(String query);
}
