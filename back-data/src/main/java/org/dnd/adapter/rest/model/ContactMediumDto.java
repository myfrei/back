package org.dnd.adapter.rest.model;

import org.dnd.domain.individual.enums.ContactType;

public record ContactMediumDto(
        ContactType contactType,
        String contactMedium) {
}
