package spring.cache;

import java.util.Optional;

public interface BookService {
    Book createBook(Book book);
    Optional<Book> getBook(String name);
    Book updateBook(Book book);

}
