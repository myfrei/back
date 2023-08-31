package org.dnd.adapter.persistence;

import org.dnd.adapter.persistence.dictionary.DictionaryCrudRepository;
import org.dnd.domain.DefaultName;
import org.dnd.domain.enums.DictionaryType;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.dnd.domain.enums.DictionaryType.DEFAULT_NAME;

@Component
public interface DefaultNameCrudRepository extends DictionaryCrudRepository<DefaultName> {
    @Override
    List<DefaultName> findAll();

    List<DefaultName> findByArchived(Boolean archived);

    @Override
    default List<DefaultName> findActual() {
        return this.findByArchived(false);
    }

    @Override
    default DictionaryType getType() {
        return DEFAULT_NAME;
    }

}
