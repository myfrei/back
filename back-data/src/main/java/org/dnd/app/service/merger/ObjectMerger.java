package org.dnd.app.service.merger;

import org.dnd.domain.individual.Individual;
import org.mapstruct.*;

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
public interface ObjectMerger {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Individual updateEntityFromRequest(Individual individual, @MappingTarget Individual individualFromDb);
}
