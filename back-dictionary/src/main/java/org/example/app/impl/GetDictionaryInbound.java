package org.example.app.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.app.api.DictionaryRepository;
import org.example.domain.Dictionary;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public record GetDictionaryInbound(DictionaryRepository dictionaryRepository) {

    public List<? extends Dictionary> execute(String name) {
        var repository = dictionaryRepository.getRepositoryByName(name);
        return repository.findActual();
    }
}
