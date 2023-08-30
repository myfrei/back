package org.dnd.adapter.rest.mapper;

import org.dnd.BackDataTest;
import org.dnd.adapter.rest.model.IndividualDto;
import org.dnd.domain.individual.Individual;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class IndividualMapperTest extends BackDataTest {

    private final static IndividualMapper INDIVIDUAL_MAPPER = Mappers.getMapper(IndividualMapper.class);

    @Test
    public void dto_to_entity_mapping_test() throws IOException {
        var individualDto = readJson("input-individual-dto.json", IndividualDto.class);
        var individual = INDIVIDUAL_MAPPER.toEntity(individualDto);
        var input = OBJECT_MAPPER.writeValueAsString(individual);
        var output = readTree("output-individual.json").toString();
        assertEquals(input, output);
    }

    @Test
    public void entity_to_dto_mapping_test() throws IOException {
        var individual = readJson("input-individual.json", Individual.class);
        var individualDto = INDIVIDUAL_MAPPER.toDto(individual);
        var input = OBJECT_MAPPER.writeValueAsString(individualDto);
        var output = readTree("output-individual-dto.json").toString();
        assertEquals(input, output);
    }
}
