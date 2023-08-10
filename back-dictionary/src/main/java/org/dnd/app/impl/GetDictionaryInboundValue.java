package org.dnd.app.impl;

import lombok.extern.slf4j.Slf4j;
import org.dnd.app.api.DictionaryRepository;
import org.dnd.domain.Dictionary;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public record GetDictionaryInboundValue(DictionaryRepository dictionaryRepository) {
    public Dictionary executeValue(String name, String code) {
        return dictionaryRepository.getValueById(name, code);
    }
}
