package org.dnd.adapter.persistens.dictionary;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dnd.adapter.persistens.dictionary.config.DictionaryFactory;
import org.dnd.app.api.DictionaryRepository;
import org.dnd.app.impl.exeption.DictionaryNotFoundException;
import org.dnd.app.impl.exeption.ErrorMessage;
import org.dnd.domain.Dictionary;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DictionaryCrudRepositoryImpl implements DictionaryRepository {

    private final DictionaryFactory dictionaryFactory;


    @Override
    public DictionaryCrudRepository<?> getRepositoryByName(String name) {
        return dictionaryFactory.getDictionaryByName(name);
    }

    @Override
    public Dictionary getValueById(String name, String id) {
        return dictionaryFactory.getDictionaryByName(name).findById(id)
                .orElseThrow(() -> new DictionaryNotFoundException(ErrorMessage.NOT_FOUND.getValue()));
    }
}
