package net.junhabaek.cleanarchitectureentity.adapter.out.persistence;

import net.junhabaek.cleanarchitectureentity.domain.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test")
@DataJpaTest
public class BookPersistenceTest {

    @PersistenceContext
    EntityManager em;

    private Publisher createNewPublisher(){
        return new Publisher("Jun", 1L);
    }

    private Book createBasicBook(Publisher publisher){
        return Book.createNewBook("my_book", "my_author", Money.ZERO, Quantity.ZERO,
                Page.of(1L), publisher);
    }

    @Transactional
    @Test
    void givenValidBookObjectWithoutID_whenPersist_thenItShouldAssignIDToEntity() {
        //given
        Publisher publisher = createNewPublisher();
        Book book = createBasicBook(publisher);

        //when
        em.persist(publisher);
        em.persist(book);

        //then
        assertNotNull(book.getId());
        //System.out.println(book.getId());
        // 1
    }

    @Transactional
    @Test
    void givenSavedBookObject_whenFindIt_thenItShouldHaveNonNullAttributes() {
        //given
        Publisher publisher = createNewPublisher();
        Book book = createBasicBook(publisher);
        em.persist(publisher);
        em.persist(book);
        Long bookId = book.getId();
        em.flush();
        em.clear();

        //when
        Book foundBook = em.find(Book.class, bookId);

        //then
        assertNotNull(foundBook.getBookName());
        assertNotNull(foundBook.getPublisher().getId());
        System.out.println(foundBook.getPublisher().getId());

        System.out.println("before get publisher's attribute");
        System.out.println(foundBook.getPublisher().getName());
        System.out.println(foundBook.getPublisher().getPublisherCode());
    }
}