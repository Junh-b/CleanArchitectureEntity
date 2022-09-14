package net.junhabaek.cleanarchitectureentity.adapter.out.persistence;

import net.junhabaek.cleanarchitectureentity.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
