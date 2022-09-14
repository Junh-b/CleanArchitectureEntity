package net.junhabaek.cleanarchitectureentity.adapter.out.persistence;

import net.junhabaek.cleanarchitectureentity.domain.Book;
import net.junhabaek.cleanarchitectureentity.domain.Money;
import net.junhabaek.cleanarchitectureentity.domain.Page;
import net.junhabaek.cleanarchitectureentity.domain.Quantity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test")
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    @Test
    void givenValidBookObjectWithoutID_whenSaveToRepository_thenItShouldAssignIDToEntity() {
        //given
        Book book = Book.createNewBook("my_book", "my_author", Money.ZERO, Quantity.ZERO,
                Page.of(1L));

        //when
        bookRepository.save(book);

        //then
        assertNotNull(book.getId());
        //System.out.println(book.getId());
        // 1
    }
}
