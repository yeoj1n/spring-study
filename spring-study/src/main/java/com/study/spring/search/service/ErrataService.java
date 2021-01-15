package com.study.spring.search.service;

import com.study.spring.search.repository.ErrataRepository;
import org.springframework.stereotype.Service;

@Service
public class ErrataService {
    private final ErrataRepository errataRepository;

    public ErrataService(ErrataRepository errataRepository) {
        this.errataRepository = errataRepository;
    }

    public String findErrata(String query) {
        return errataRepository.findByQuery(query);
    }
}
