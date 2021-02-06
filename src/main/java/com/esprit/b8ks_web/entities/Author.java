package com.esprit.b8ks_web.entities;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_AUTHOR")
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "A_ID")
    private long id;
    @Column(name = "A_NAME")
    private String name;
    @Column(name = "A_AGE")
    private int age;
    @Column(name = "A_IMG")
    private String img;

    public Author() {
    }

    public Author(long id, String name, int age, String img) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.img = img;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", img='" + img + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (id != author.id) return false;
        return name != null ? name.equals(author.name) : author.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
