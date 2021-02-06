package com.esprit.b8ks_web.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "T_BOOK")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "B_ID")
    private long id;
    @Column(name = "B_TITLE")
    private String title;
    @Column(name = "B_DESC")
    private String description;
    @Column(name = "B_PRICE")
    private double price;
    @ManyToOne
    @JoinColumn(name = "A_ID")
    @JsonIgnoreProperties("books")
    private Author aut;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "T_BOOK_CATEGORIES", joinColumns = @JoinColumn(name = "B_ID"), inverseJoinColumns = @JoinColumn(name = "C_ID"))
    private Set<Category> cat = new HashSet<>();
    @Column(name = "B_LANGUAGE")
    @Enumerated(EnumType.STRING)
    private Language lang;
    @Column(name = "B_STOCK")
    private boolean stock;

    public Book() {
    }

    public Book(long id, String title, String description, double price, Author aut, Set<Category> cat, Language lang, boolean stock) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.aut = aut;
        this.cat = cat;
        this.lang = lang;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAut() {
        return aut;
    }

    public void setAut(Author aut) {
        this.aut = aut;
    }

    public Set<Category> getCat() {
        return cat;
    }

    public void setCat(Set<Category> cat) {
        this.cat = cat;
    }

    public Language getLang() {
        return lang;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", aut=" + aut +
                ", cat=" + cat +
                ", lang=" + lang +
                ", stock=" + stock +
                '}';
    }
}