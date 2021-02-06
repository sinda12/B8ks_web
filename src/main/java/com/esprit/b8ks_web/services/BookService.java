package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.Book;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface BookService {
    public Book saveBook(Book b);

    public List<Book> saveBooks(List<Book> books);

    public List<Book> getBooks(String string);

    public List<Book> SortedByTitleA();

    public List<Book> SortedByTitleD();

    public List<Book> SortedByPriceA();

    public List<Book> SortedByPriceD();

    public List<Book> FilteredByCat(String catL);

    public List<Book> FilteredByLang(String langL);

    public List<Book> FilteredByMinP(double minP);

    public List<Book> FilteredByMaxP(double maxP);

    public List<Book> FilteredByMinMaxP(double minP, double max);

    public Book getBookById(long id);

    public Book getBookByTitle(String title);

    public String deleteBook(long id);

    public String updateBook(Book b);

}
