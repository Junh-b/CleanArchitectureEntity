package net.junhabaek.cleanarchitectureentity.adapter.out.persistence;

import net.junhabaek.cleanarchitectureentity.domain.Book;
import net.junhabaek.cleanarchitectureentity.domain.Money;
import net.junhabaek.cleanarchitectureentity.domain.Page;
import net.junhabaek.cleanarchitectureentity.domain.Quantity;
import org.junit.jupiter.api.Test;
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

    private Book createBasicBook(){
        return Book.createNewBook("my_book", "my_author", Money.ZERO, Quantity.ZERO,
                Page.of(1L));
    }

    @Transactional
    @Test
    void givenValidBookObjectWithoutID_whenPersist_thenItShouldAssignIDToEntity() {
        //given
        Book book = createBasicBook();

        //when
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
        Book book = createBasicBook();
        em.persist(book);
        Long bookId = book.getId();
        em.flush();
        em.clear();

        //when
        Book foundBook = em.find(Book.class, bookId);

        //then
        assertNotNull(foundBook.getBookName());
    }
}
