package org.example.adapter.persistens.dictionary;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.adapter.persistens.dictionary.config.DictionaryFactory;
import org.example.app.api.DictionaryRepository;
import org.example.app.impl.exeption.DictionaryNotFoundException;
import org.example.app.impl.exeption.ErrorMessage;
import org.example.domain.Dictionary;
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
