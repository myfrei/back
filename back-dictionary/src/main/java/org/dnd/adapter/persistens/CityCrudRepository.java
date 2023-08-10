package org.dnd.adapter.persistens;

import org.dnd.adapter.persistens.dictionary.DictionaryCrudRepository;
import org.dnd.domain.City;
import org.dnd.domain.enums.DictionaryType;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.dnd.domain.enums.DictionaryType.CITY;

@Component
public interface CityCrudRepository extends DictionaryCrudRepository<City> {
    @Override
    List<City> findAll();

    List<City> findByArchived(Boolean archived);

    @Override
    default List<City> findActual() {
        return this.findByArchived(false);
    }

    @Override
    default DictionaryType getType() {
        return CITY;
    }
}
