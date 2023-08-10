package org.example.app.api;

import org.example.adapter.persistens.dictionary.DictionaryCrudRepository;
import org.example.domain.Dictionary;

public interface DictionaryRepository {
    DictionaryCrudRepository<?> getRepositoryByName(String name);
    Dictionary getValueById(String name, String id);
}
