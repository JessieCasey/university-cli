package com.university.cambridge.strategies.impl;

import com.university.cambridge.repository.LectorRepository;
import com.university.cambridge.strategies.GlobalSearchStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.university.cambridge.ApplicationConstants.ConsoleResponse.LECTORS_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class GlobalSearchServiceImpl implements GlobalSearchStrategy {

    private final LectorRepository lectorRepository;

    @Override
    public String search(String template) {
        List<String> results = lectorRepository.findLectorsByTemplate(template);
        return results.size() == 0 ? LECTORS_NOT_FOUND + "\n" + results : results.toString();
    }
}
