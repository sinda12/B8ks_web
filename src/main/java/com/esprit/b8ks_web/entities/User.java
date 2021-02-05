package com.esprit.b8ks_web.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;
    private int age;
    private String mobile;
    private String nom,prenom,adresse,email,password;
    private Boolean isAdmin ;


   /* @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
    /*private List<Order> orders = new ArrayList<Order>();*/
  /*  private List<Blog> blogs = new ArrayList<Blog>() ;
    private List<UsedBook> usedBooks = new ArrayList<UsedBook>() ;
    private List<Claim> claims = new ArrayList<Claim>() ;
    private List<NewsLetter> newsLetters = new ArrayList<NewsLetter>() ;*/

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(String mobile, int age, String nom, String prenom, String adresse, String email, String password, Boolean isAdmin) {
        this.mobile = mobile;
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        /*  this.orders = orders;*/
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }


}