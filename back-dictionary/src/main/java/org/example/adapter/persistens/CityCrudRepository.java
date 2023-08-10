package org.example.adapter.persistens;

import org.example.adapter.persistens.dictionary.DictionaryCrudRepository;
import org.example.domain.City;
import org.example.domain.enums.DictionaryType;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.example.domain.enums.DictionaryType.CITY;

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
