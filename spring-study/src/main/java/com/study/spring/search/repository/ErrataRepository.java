package com.study.spring.search.repository;

public interface ErrataRepository {
    String findByQuery(String query);
}
