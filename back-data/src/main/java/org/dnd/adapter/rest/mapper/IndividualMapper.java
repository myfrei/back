package org.dnd.adapter.rest.mapper;

import org.dnd.adapter.rest.model.ContactMediumDto;
import org.dnd.adapter.rest.model.IndividualDto;
import org.dnd.domain.individual.Individual;
import org.dnd.domain.individual.enums.ContactType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface IndividualMapper {

    @Mapping(target = "contactMediumDto", source = "contactMedium")
    IndividualDto toDto(Individual individual);

    @Mapping(target = "contactMedium", source = "contactMediumDto")
    Individual toEntity(IndividualDto individualDto);

    default ContactMediumDto mapContactMedium(Map<ContactType, String> contactMedium) {
        if (contactMedium == null || contactMedium.isEmpty()) {
            return null;
        }
        Optional<ContactType> result = contactMedium.keySet().stream().findFirst();
        return new ContactMediumDto(result.get(), contactMedium.get(result.get()));
    }

    default Map<ContactType, String> mapContactMediumDto(ContactMediumDto contactMediumDto) {
        if (contactMediumDto == null || contactMediumDto.contactMedium() == null) {
            return null;
        }
        Map<ContactType, String> contactMedium = new HashMap<>();
        contactMedium.put(contactMediumDto.contactType(), contactMediumDto.contactMedium());
        return contactMedium;
    }
}