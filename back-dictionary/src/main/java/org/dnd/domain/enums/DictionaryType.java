package org.dnd.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import one.util.streamex.StreamEx;

import java.util.Optional;

@Getter
@RequiredArgsConstructor
public enum DictionaryType {
    CITY("city"),
    DEFAULT_NAME("default_name"),

    CAR("car");

    private final String name;

    public static Optional<DictionaryType> getByName(String name) {

        return StreamEx.of(DictionaryType.values())
                .findFirst(x -> x.getName().equals(name));
    }
}
