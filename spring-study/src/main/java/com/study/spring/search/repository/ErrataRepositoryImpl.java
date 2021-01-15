package com.study.spring.search.repository;

import com.study.spring.config.NaverProperties;
import com.study.spring.search.dao.ResponseErrata;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ErrataRepositoryImpl implements ErrataRepository {
    private final RestTemplate restTemplate;
    private final NaverProperties naverProperties;

    public ErrataRepositoryImpl(RestTemplate restTemplate, NaverProperties naverProperties) {
        this.restTemplate = restTemplate;
        this.naverProperties = naverProperties;
    }

    @Override
    public String findByQuery(String query) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", naverProperties.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", naverProperties.getClientSecret());

        String url = naverProperties.getErrataUrl() + "?query=" + query;

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseErrata.class)
                .getBody()
                .getErrata();
    }
}
