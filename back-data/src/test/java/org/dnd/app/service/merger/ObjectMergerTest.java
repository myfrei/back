package org.dnd.app.service.merger;

import org.dnd.BackDataTest;
import org.dnd.domain.individual.Individual;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ObjectMergerTest extends BackDataTest {

    private final static ObjectMerger OBJECT_MERGER = Mappers.getMapper(ObjectMerger.class);

    @Test
    public void create_individual_from_request() throws IOException {
        updateFromRequest();
    }

    @Test
    public void delete_individual_from_request() throws IOException {
        updateFromRequest();
    }

    @Test
    public void not_update_individual_from_request() throws IOException {
        updateFromRequest();
    }

    @Test
    public void update_individual_from_request() throws IOException {
        updateFromRequest();
    }

    private void updateFromRequest() throws IOException {
        var requestIndividual = readJson("request-individual.json", Individual.class);
        var individualFromDb = readJson("individual-from-db.json", Individual.class);
        var individualOutput = readTree("output-individual.json").toString();

        OBJECT_MERGER.updateEntityFromRequest(requestIndividual, individualFromDb);
        var individualInput = OBJECT_MAPPER.writeValueAsString(individualFromDb);

        assertEquals(individualInput, individualOutput);
    }
}
