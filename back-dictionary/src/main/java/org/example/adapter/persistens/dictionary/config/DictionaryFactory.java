package org.example.adapter.persistens.dictionary.config;

import org.example.adapter.persistens.dictionary.DictionaryCrudRepository;
import org.example.app.impl.exeption.DictionaryNotFoundException;
import org.example.app.impl.exeption.ErrorMessage;
import org.example.domain.Dictionary;
import org.example.domain.enums.DictionaryType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public record DictionaryFactory(
        Map<DictionaryType, ? extends DictionaryCrudRepository<? extends Dictionary>> dictionariesMap
) {

    public DictionaryCrudRepository<? extends Dictionary> getDictionaryByName(String name) {
        return dictionariesMap.get(DictionaryType.getByName(name)
                .orElseThrow(() -> new DictionaryNotFoundException(ErrorMessage.NOT_FOUND.getValue())));
    }

}
