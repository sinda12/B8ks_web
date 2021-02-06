package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.Book;
import com.esprit.b8ks_web.entities.Category;
import com.esprit.b8ks_web.repository.BookRepo;
import com.esprit.b8ks_web.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IBookService implements BookService {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    public Book saveBook(Book b) {
        return bookRepo.save(b);
    }

    public List<Book> saveBooks(List<Book> books) {
        return bookRepo.saveAll(books);
    }

    public List<Book> getBooks(String string) {
        List<Book> books = new ArrayList<>();
        if (string != null)
            books = bookRepo.findBooksByTitle(string);
        else {
            books = bookRepo.findAll();
        }
        return books;
    }

    public List<Book> SortedByTitleA() {
        List<Book> books = bookRepo.findAll(Sort.by(Sort.Direction.ASC, "label"));
        return books;
    }

    public List<Book> SortedByTitleD() {
        List<Book> books = bookRepo.findAll(Sort.by(Sort.Direction.DESC, "label"));
        return books;
    }

    public List<Book> SortedByPriceA() {
        List<Book> books = bookRepo.findAll(Sort.by(Sort.Direction.ASC, "price"));
        return books;
    }

    public List<Book> SortedByPriceD() {
        List<Book> books = bookRepo.findAll(Sort.by(Sort.Direction.DESC, "price"));
        return books;
    }

    public List<Book> FilteredByCat(String catL) {
        Set<Category> categories = new HashSet<>();
        String[] stringL = catL.split(" ");
        for (String string : stringL) {
            categories.add(new Category(1, string));
        }
        List<Book> books = bookRepo.findAll();
        return books.stream().filter(b -> b.getCat().containsAll(categories)).collect(Collectors.toList());
    }


    public List<Book> FilteredByLang(String langList) {
        List<Book> books = bookRepo.findAll();
        return books.stream().filter(b -> langList.contains(b.getLang().toString()))
                .collect(Collectors.toList());
    }

    public List<Book> FilteredByMinP(double minP) {
        List<Book> books = bookRepo.findAll();
        return books.stream().filter(b -> (int) b.getPrice() >= (int) minP).collect(Collectors.toList());
    }

    public List<Book> FilteredByMaxP(double maxP) {
        List<Book> books = bookRepo.findAll();
        return books.stream().filter(b -> (int) b.getPrice() <= (int) maxP).collect(Collectors.toList());
    }

    public List<Book> FilteredByMinMaxP(double minP, double maxP) {
        List<Book> books = bookRepo.findAll();
        return books.stream()
                .filter(b -> ((int) b.getPrice() <= (int) maxP) && ((int) b.getPrice() >= (int) minP))
                .collect(Collectors.toList());
    }

    public Book getBookById(long id) {
        Book book = bookRepo.findById((int) id).orElse(null);
        return book;
    }

    public Book getBookByTitle(String title) {
        Book book = bookRepo.findByTitle(title);
        return book;
    }

    public String deleteBook(long id) {
        bookRepo.deleteById((int) id);
        return "Deleted !";
    }

    public String updateBook(Book b) {
        Book thisBook = bookRepo.findById((int) b.getId()).orElse(null);
        if (b.getTitle() != null)
            thisBook.setTitle(b.getTitle());
        if (thisBook.isStock() != b.isStock())
            thisBook.setStock(b.isStock());
        if (b.getPrice() != 0)
            thisBook.setPrice(b.getPrice());
        if (b.getLang() != null)
            thisBook.setLang(b.getLang());
        if (b.getDescription() != null)
            thisBook.setDescription(b.getDescription());
        if (b.getCat().size() != 0) {
            Set<Category> cat = b.getCat();
            for (Category category : cat) {
                category.setId(categoryRepo.findByCategoryName(category.getCategoryName()).getId());
            }
            thisBook.setCat(cat);
        }

        bookRepo.save(thisBook);
        return "Updated !";
    }

}
