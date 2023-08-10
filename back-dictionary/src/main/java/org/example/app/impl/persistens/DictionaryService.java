package org.example.app.impl.persistens;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.adapter.persistens.dictionary.DictionaryCrudRepository;
import org.example.domain.Dictionary;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class DictionaryService {
    private final Map<String, ?extends DictionaryCrudRepository<? extends Dictionary>> dictionary;

    public DictionaryCrudRepository<? extends Dictionary> getRepositoryByName(String name) {
        return null;
    }
}
