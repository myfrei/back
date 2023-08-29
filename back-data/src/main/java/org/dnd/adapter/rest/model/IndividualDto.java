package org.dnd.adapter.rest.model;

public record IndividualDto(
        String icp,
        String name,
        String surname,
        String patronymic,
        Integer age,
        ContactMediumDto contactMediumDto) {
}
