package spring.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BookServiceImpl implements BookService{
    private final ConcurrentHashMap<String, Book> books = new ConcurrentHashMap<>();

    @Override
    public Book createBook(Book book) {
        books.put(book.getName(), book);
        return book;
    }

    @Override
    @Cacheable("books")
    public Optional<Book> getBook(String name) {
        // Simulate slow service
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return Optional.ofNullable(books.get(name));
    }

    @Override
    public Book updateBook(Book book) {
        books.put(book.getName(), book);
        return book;
    }

}
