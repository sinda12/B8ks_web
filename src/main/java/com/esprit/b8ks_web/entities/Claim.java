package com.esprit.b8ks_web.entities;

import org.hibernate.annotations.CreationTimestamp;
import com.esprit.b8ks_web.entities.User;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="claims")
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @CreationTimestamp
    private Date date;
    private String status;
    @ManyToOne
    private static User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static String getUser() {
        return user.getNom();
    }
}
