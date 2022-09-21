package net.junhabaek.cleanarchitectureentity.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter(value = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookName;
    private String authorName;
    @Embedded
    private Money price;
    @Embedded
    private Quantity quantity;
    @Embedded
    private Page page;

    @ManyToOne(fetch=FetchType.LAZY)
    private Publisher publisher;

    public static Book createNewBook(String bookName, String authorName, Money price, Quantity quantity, Page page,
                                     Publisher publisher){
        Book book = new Book();

        book.setBookName(bookName);
        book.setAuthorName(authorName);
        book.setPrice(price);
        book.setQuantity(quantity);
        book.setPage(page);
        book.setPublisher(publisher);

        //can emit domain event here

        return book;
    }

    public static Book restoreBook(Long id, String bookName, String authorName, Money price, Quantity quantity, Page page){
        Book book = new Book();

        book.setId(id);
        book.setBookName(bookName);
        book.setAuthorName(authorName);
        book.setPrice(price);
        book.setQuantity(quantity);
        book.setPage(page);

        return book;
    }

    public void changeBookName(String bookName){
        this.bookName = bookName;

        //can emit domain event here
    }

    public void changePrice(Money price){
        this.price = price;

        // can emit domain event here
    }
}