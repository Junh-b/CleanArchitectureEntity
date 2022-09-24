package net.junhabaek.cleanarchitectureentity.domain;

import lombok.Getter;

import java.util.Objects;

public class Page {
    @Getter
    private final Long page;

    public Page plus(Page other){
        return new Page(this.page + other.page);
    }
    public Page minus(Page other) {
        return new Page(this.page - other.page);
    }
    public Page multiply(Long times) {
        return new Page(this.page * times);
    }

    private Page() {
        this.page = 0L;
    }

    public Page(Long page) {
        if(page == null || page.compareTo(1L) < 0) {
            throw new IllegalStateException("Page can not have value that below 1.");
        }
        this.page = page;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page page1 = (Page) o;
        return page.equals(page1.page);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page);
    }

    public static Page of(Long value){
        return new Page(value);
    }
}
