package com.esprit.b8ks_web.repository;

import com.esprit.b8ks_web.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    Book findByTitle(String title);

    @Query("SELECT B from Book B WHERE B.title LIKE %?1%")
    public List<Book> findBooksByTitle(String string);

    @Query("Select b from book b join category c ON b.category.id = c.id WHERE c.id=?1")
    public List<Book> findBookByCat(String string);
}