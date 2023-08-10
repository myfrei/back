package org.dnd.app.service.merger;

import org.dnd.domain.individual.Individual;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "string")
public interface ObjectMerger {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Individual updateEntityFromRequest(Individual individual, @MappingTarget Individual individualFromDb);
}
