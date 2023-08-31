package org.dnd.adapter.persistence.dictionary;

import org.dnd.domain.Dictionary;
import org.dnd.domain.enums.DictionaryType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface DictionaryCrudRepository<T extends Dictionary> extends CrudRepository<T, String> {
    List<T> findAll();

    List<T> findActual();

    Optional<T> findById(String id);

    DictionaryType getType();

}
