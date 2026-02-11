package com.example.BookApplication.Controller;

import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books/v1")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return ResponseEntity.ok(savedBook);
    }

    /**
     * Retrieve book based on its id
     *
     * @param id identifier of the book
     * @return Book for requested ID if its found
     */
    @GetMapping ("/getBook/{id}")
    public Book getBookbyId(@PathVariable Long id){
        Book savedBook = bookService.getBook(id);
        return savedBook;
    }
}
