package org.example.domain;


import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
public abstract class DictionaryBaseEntity implements Dictionary {

    @Id
    @Getter
    private String id;

    @Getter
    private String value;

    private Boolean archived;

    public Boolean isArchived() {
        return this.archived;
    }
}
