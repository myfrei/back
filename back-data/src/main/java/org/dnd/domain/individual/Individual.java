package org.dnd.domain.individual;

import lombok.Getter;
import lombok.Setter;
import org.dnd.domain.individual.enums.ContactType;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "individual")
@Getter
@Setter
public class Individual {

    @Id
    private String uuid;

    private String icp;

    private String name;

    private String surname;

    private String patronymic;

    private Integer age;

    @ElementCollection
    @CollectionTable(name = "individual_contact", joinColumns = @JoinColumn(name = "individual_uuid"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "contact_type")
    @Column(name = "value")
    private Map<ContactType, String> contactMedium;
}