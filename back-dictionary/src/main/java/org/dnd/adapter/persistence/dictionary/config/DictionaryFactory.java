package org.dnd.adapter.persistence.dictionary.config;

import org.dnd.adapter.persistence.dictionary.DictionaryCrudRepository;
import org.dnd.app.impl.exeption.DictionaryNotFoundException;
import org.dnd.app.impl.exeption.ErrorMessage;
import org.dnd.domain.Dictionary;
import org.dnd.domain.enums.DictionaryType;
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
