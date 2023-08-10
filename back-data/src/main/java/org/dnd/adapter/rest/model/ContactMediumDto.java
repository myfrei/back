package org.dnd.adapter.rest.model;

import org.dnd.domain.individual.enums.ContactType;

import java.util.List;

public record ContactMediumDto(
        ContactType contactType,
        List<String> contactMedium) {}
