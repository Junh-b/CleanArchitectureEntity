package net.junhabaek.cleanarchitectureentity.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Access(value = AccessType.FIELD)
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Publisher {
    @Id @Column(name="publisher_id")
    private Long id;

    private String name;

    private Long publisherCode;

    public Publisher(Long id, String name, Long publisherCode) {
        this.id = id;
        this.name = name;
        this.publisherCode = publisherCode;
    }
}
