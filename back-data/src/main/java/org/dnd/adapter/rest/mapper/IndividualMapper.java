package org.dnd.adapter.rest.mapper;

import org.dnd.adapter.rest.model.IndividualDto;
import org.dnd.domain.individual.Individual;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "string")
public interface IndividualMapper {

    IndividualDto toDto(Individual individual);

    Individual toEntity(IndividualDto individualDto);
}
