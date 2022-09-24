package net.junhabaek.cleanarchitectureentity.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Publisher {
    private Long id;

    private String name;

    private Long publisherCode;

    public Publisher(String name, Long publisherCode) {
        this.name = name;
        this.publisherCode = publisherCode;
    }
}