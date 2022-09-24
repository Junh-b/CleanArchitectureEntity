package net.junhabaek.cleanarchitectureentity.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Access(value=AccessType.FIELD)
@Getter
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
    @JoinColumn(name="publisher_id")
    private Publisher publisher;

    public static Book createNewBook(String bookName, String authorName, Money price, Quantity quantity, Page page,
                                     Publisher publisher){
        Book book = new Book();

        book.bookName = bookName;
        book.authorName = authorName;
        book.price = price;
        book.quantity = quantity;
        book.page = page;
        book.publisher = publisher;

        //can emit domain event here

        return book;
    }

    public static Book restoreBook(Long id, String bookName, String authorName, Money price, Quantity quantity, Page page,
                                   Publisher publisher){
        Book book = new Book();

        book.id = id;
        book.bookName = bookName;
        book.authorName = authorName;
        book.price = price;
        book.quantity = quantity;
        book.page = page;
        book.publisher = publisher;

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