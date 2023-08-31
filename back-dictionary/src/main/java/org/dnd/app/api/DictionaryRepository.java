package org.dnd.app.api;

import org.dnd.adapter.persistence.dictionary.DictionaryCrudRepository;
import org.dnd.domain.Dictionary;

public interface DictionaryRepository {
    DictionaryCrudRepository<?> getRepositoryByName(String name);
    Dictionary getValueById(String name, String id);
}
