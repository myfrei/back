package org.dnd.domain.individual;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.dnd.domain.individual.enums.ContactType;

import java.util.List;

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

    @Enumerated(EnumType.STRING)
    private ContactType contactType;

    @ElementCollection
    @CollectionTable(name = "individual_contact", joinColumns = @JoinColumn(name = "value"))
    @Column(name = "contact_medium")
    private List<String> contactMedium;

}
