package spring.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping("/{name}")
    public Optional<Book> getBook(@PathVariable String name) {
        return bookService.getBook(name);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {return bookService.updateBook(book);}


}
