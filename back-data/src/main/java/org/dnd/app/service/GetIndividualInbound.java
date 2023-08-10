package org.dnd.app.service;


import org.dnd.adapter.persistence.IndividualCrudRepository;
import org.dnd.app.exeption.ErrorMessage;
import org.dnd.app.exeption.IndividualNotFoundException;
import org.dnd.domain.individual.Individual;
import org.springframework.stereotype.Service;

@Service
public record GetIndividualInbound(IndividualCrudRepository individualCrudRepository) {
    public Individual handleRequest(String icp) {
        return individualCrudRepository.findByIcp(icp)
                .orElseThrow(() -> new IndividualNotFoundException((ErrorMessage.NOT_FOUND.getValue()).formatted(icp)));
    }
}
