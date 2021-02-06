package com.esprit.b8ks_web.controllers;

import com.esprit.b8ks_web.entities.Book;
import com.esprit.b8ks_web.services.BookService;
import com.esprit.b8ks_web.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;


    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book b) {
        System.out.println(b);
        return bookService.saveBook(b);
    }

    @PostMapping("/addBooks")
    public List<Book> addBooks(@RequestBody List<Book> books) {
        return bookService.saveBooks(books);
    }

    @GetMapping("/books")
    public List<Book> findAllBooks(@Param("string") String string) {
        return bookService.getBooks(string);
    }

    @GetMapping("/books/sortLabel/{ord}")
    public List<Book> SortedByTitle(@PathVariable int ord) {
        if (ord == 1)
            return bookService.SortedByTitleA();
        else
            return bookService.SortedByTitleD();
    }

    @GetMapping("/books/sortPrice/{ord}")
    public List<Book> SortedByP(@PathVariable int ord) {
        if (ord == 1)
            return bookService.SortedByPriceA();
        else
            return bookService.SortedByPriceD();
    }

    @GetMapping("/books/categories/{string}")
    public List<Book> FilteredByCat(@Param("string") String string) {
        return bookService.FilteredByCat(string);
    }

    @GetMapping("/books/languages")
    public List<Book> FilteredByLang(@Param("names") String string) {
        return bookService.FilteredByLang(string);
    }

    @GetMapping("/books/minPrice/{min}")
    public List<Book> FilteredByMinP(@PathVariable double min) {
        return bookService.FilteredByMinP(min);
    }

    @GetMapping("/books/maxPrice/{max}")
    public List<Book> FilteredByMaxP(@PathVariable double max) {
        return bookService.FilteredByMaxP(max);
    }

    @GetMapping("/books/price")
    public List<Book> findAllBooksFilteredByPrice(@Param("min") double min,
                                                  @Param("max") double max) {
        return bookService.FilteredByMinMaxP(min, max);
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable int id) {

        return bookService.getBookById(id);
    }

    @GetMapping("/bookTitle/{title}")
    public Book getBookByTitle(@PathVariable String title) {
        return bookService.getBookByTitle(title);
    }

    @PutMapping("/updateBook")
    public String updateBook(@RequestBody Book b) {
        return bookService.updateBook(b);
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id) {
        return bookService.deleteBook(id);
    }


}
