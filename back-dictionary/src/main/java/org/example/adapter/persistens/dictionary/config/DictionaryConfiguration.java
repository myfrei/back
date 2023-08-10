package org.example.adapter.persistens.dictionary.config;

import one.util.streamex.StreamEx;
import org.example.adapter.persistens.dictionary.DictionaryCrudRepository;
import org.example.domain.Dictionary;
import org.example.domain.enums.DictionaryType;
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
