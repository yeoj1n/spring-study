package com.study.spring.search.service;

import com.study.spring.search.dto.Movie;
import com.study.spring.search.dto.MovieGroup;
import com.study.spring.search.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findMovies(final String query) {
        MovieGroup movieList = new MovieGroup(movieRepository.findByQuery(query));
        return movieList.getListOrderRating();
    }
}
