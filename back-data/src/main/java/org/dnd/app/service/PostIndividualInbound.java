package org.dnd.app.service;

import one.util.streamex.StreamEx;
import org.dnd.adapter.persistence.IndividualCrudRepository;
import org.dnd.app.service.merger.ObjectMerger;
import org.dnd.domain.individual.Individual;
import org.dnd.domain.individual.enums.ContactType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public record PostIndividualInbound(IndividualCrudRepository individualCrudRepository,
                                    ObjectMerger objectMerger,
                                    KafkaTemplate<String, String> kafkaTemplate) {
    public Individual handleRequest(Individual individualFromDto) {
        return individualCrudRepository.findByIcp(individualFromDto.getIcp())
                .map(individualFromDb -> individualCrudRepository
                        .save(objectMerger.updateEntityFromRequest(individualFromDto, individualFromDb)))
                .orElseGet(() -> {
                    individualFromDto.setUuid(getUuid());
                    sendMessage(individualFromDto);
                    return individualCrudRepository.save(individualFromDto);
                });
    }


    private String getUuid() {
        return UUID.randomUUID().toString();
    }

    private void sendMessage(Individual individual) {
        ContactType contactType =
                ContactType.valueOf(
                        StreamEx.ofKeys(individual.getContactMedium()).joining());
        switch (contactType) {
            case EMAIL ->
                kafkaTemplate.send(ContactType.EMAIL.toString(), sendEmailMessage(individual));

            case PHONE ->
                kafkaTemplate.send(ContactType.PHONE.toString(), sendSmsMessage(individual));

        }
    }

    private String sendSmsMessage(Individual individual) {
        return ("%s %s %s Благодарим за регистрацию Ваш icp = %s," +
                " проверьте указанную контактную информация для связи = %s")
                .formatted(
                        individual.getSurname(), individual.getName(), individual.getPatronymic(),
                        individual.getIcp(), individual.getContactMedium().get(ContactType.PHONE));
    }

    private String sendEmailMessage(Individual individual) {
        return ("%s %s %s Благодарим за регистрацию Ваш icp = %s," +
                " подробную информацию отправили на Ваш email = %s")
                .formatted(
                        individual.getSurname(), individual.getName(), individual.getPatronymic(),
                        individual.getIcp(), individual.getContactMedium().get(ContactType.EMAIL));
    }
}
