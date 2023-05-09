package com.university.cambridge.strategies.impl;

import com.university.cambridge.repository.LectorRepository;
import com.university.cambridge.strategies.GlobalSearchStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GlobalSearchServiceImpl implements GlobalSearchStrategy {

    private final LectorRepository lectorRepository;

    @Override
    public String search(String template) {
        return lectorRepository.findLectorsByTemplate(template).toString();
    }
}
