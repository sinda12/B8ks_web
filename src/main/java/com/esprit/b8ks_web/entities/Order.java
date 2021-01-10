package com.esprit.b8ks_web.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="book_order")
public class Order {
    @Id
    @GeneratedValue

    private int id;






}
