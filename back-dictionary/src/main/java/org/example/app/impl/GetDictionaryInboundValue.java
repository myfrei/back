package org.example.app.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.app.api.DictionaryRepository;
import org.example.domain.Dictionary;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public record GetDictionaryInboundValue(DictionaryRepository dictionaryRepository) {
    public Dictionary executeValue(String name, String code) {
        return dictionaryRepository.getValueById(name, code);
    }
}
