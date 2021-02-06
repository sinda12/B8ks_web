package com.esprit.b8ks_web.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "T_CATEGORY")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_ID")
    private long id;
    @Column(name = "C_NAME")
    private String categoryName;
    @ManyToMany(mappedBy = "cat", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

    public Category() {
    }

    public Category(long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public Category(int id, String categoryName, Set<Book> books) {
        this.id = id;
        this.categoryName = categoryName;
        this.books = books;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
