package org.dnd.adapter.persistens.dictionary.config;

import one.util.streamex.StreamEx;
import org.dnd.adapter.persistens.dictionary.DictionaryCrudRepository;
import org.dnd.domain.Dictionary;
import org.dnd.domain.enums.DictionaryType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Set;

@Configuration
public class DictionaryConfiguration {

    @Bean
    public Map<DictionaryType, ? extends DictionaryCrudRepository<? extends Dictionary>> dictionaryMap(
            Set<DictionaryCrudRepository<? extends Dictionary>> dictionaries
    ) {
        {
            return StreamEx.of(dictionaries)
                    .toMap(DictionaryCrudRepository::getType, dict -> dict);
        }
    }
}
