package net.junhabaek.cleanarchitectureentity.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(value = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Book {
    private Long id;
    private String bookName;
    private String authorName;
    private Money price;
    private Quantity quantity;
    private Page page;

    public static Book createNewBook(String bookName, String authorName, Money price, Quantity quantity, Page page){
        Book book = new Book();

        book.setBookName(bookName);
        book.setAuthorName(authorName);
        book.setPrice(price);
        book.setQuantity(quantity);
        book.setPage(page);

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
