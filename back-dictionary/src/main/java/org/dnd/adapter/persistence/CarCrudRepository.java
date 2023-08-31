package org.dnd.adapter.persistence;

import org.dnd.adapter.persistence.dictionary.DictionaryCrudRepository;
import org.dnd.domain.Car;
import org.dnd.domain.enums.DictionaryType;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.dnd.domain.enums.DictionaryType.CAR;

@Component
public interface CarCrudRepository extends DictionaryCrudRepository<Car> {
    @Override
    List<Car> findAll();

    List<Car> findByArchived(Boolean archived);

    @Override
    default List<Car> findActual() {
        return this.findByArchived(false);
    }

    @Override
    default DictionaryType getType() {
        return CAR;
    }
}
