package org.dnd.adapter.persistence;

import org.dnd.domain.individual.Individual;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IndividualCrudRepository extends CrudRepository<Individual, String> {
    Optional<Individual> findByIcp(String icp);
}
