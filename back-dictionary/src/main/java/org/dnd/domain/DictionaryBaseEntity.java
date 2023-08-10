package org.dnd.domain;


import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
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
