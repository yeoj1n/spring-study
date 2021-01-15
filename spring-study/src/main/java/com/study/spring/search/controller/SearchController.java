package com.study.spring.search.controller;

import com.study.spring.search.dto.Movie;
import com.study.spring.search.service.ErrataService;
import com.study.spring.search.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {
    private final MovieService movieService;
    private final ErrataService errataService;

    public SearchController(MovieService movieService, ErrataService errataService) {
        this.movieService = movieService;
        this.errataService = errataService;
    }

    /*
     * 검색 > 영화 (네이버 영화 검색 결과를 출력해주는 REST API)
     * */
    @GetMapping("/movie")
    public List<Movie> findMoviesByQuery(@RequestParam(name="query") String query) {
        return movieService.findMovies(query);
    }

    /*
    * 검색 > 오타변환 (한/영 키를 잘못 설정하고 검색한 경우, 입력하신 검색어를 자동으로 변환/추천해 주는 REST API)
    * */
    @GetMapping("/errata")
    public String findErrataByQuery(@RequestParam(name="query") String query) {
        return errataService.findErrata(query);
    }
}
