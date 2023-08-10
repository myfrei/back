package org.dnd.adapter.rest.model;

import java.util.List;

public record IndividualDto(
        String icp,
        String name,
        String surname,
        String patronymic,
        Integer age,
        ContactMediumDto contactMediumDto,
        List<String> contactMedium) {}
