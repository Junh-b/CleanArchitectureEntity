package net.junhabaek.cleanarchitectureentity.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Access(value = AccessType.FIELD)
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Publisher {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="publisher_id")
    private Long id;

    private String name;

    private Long publisherCode;

    public Publisher(String name, Long publisherCode) {
        this.name = name;
        this.publisherCode = publisherCode;
    }
}
