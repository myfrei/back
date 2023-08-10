package org.dnd.app.service;

import org.dnd.adapter.persistence.IndividualCrudRepository;
import org.dnd.app.service.merger.ObjectMerger;
import org.dnd.domain.individual.Individual;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public record PostIndividualInbound(IndividualCrudRepository individualCrudRepository, ObjectMerger objectMerger) {
    public Individual handleRequest(Individual individualFromDto) {
        return individualCrudRepository.findByIcp(individualFromDto.getIcp())
                .map(individualFromDb -> individualCrudRepository
                        .save(objectMerger.updateEntityFromRequest(individualFromDto, individualFromDb)))
                .orElseGet(() -> {
                    individualFromDto.setUuid(getUuid());
                    return individualCrudRepository.save(individualFromDto);
                });
    }


    private String getUuid() {
        return UUID.randomUUID().toString();
    }
}
