package net.junhabaek.cleanarchitectureentity.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Access(value = AccessType.PROPERTY)
@Setter(value=AccessLevel.PUBLIC) @NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Publisher {
    Long id;

    String name;

    Long publisherCode;

    public Publisher(Long id, String name, Long publisherCode) {
        this.id = id;
        this.name = name;
        this.publisherCode = publisherCode;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPublisherCode() {
        return publisherCode;
    }
}
