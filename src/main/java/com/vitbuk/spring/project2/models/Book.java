package com.vitbuk.spring.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="Book")
public class Book {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name of the book should not be empty")
    @Column(name="name")
    @Size(min=1, max=100, message="Book title cant be less than 1 and more than 100")
    private String name;

    @NotEmpty
    @Column(name="author")
    @Size(min=1, max=100, message = "Author name cant be less than 1 and mote than 100")
    private String author;

    @NotEmpty(message = "Year could not be empty")
    @Min(value=1500, message = "Year shold be more than 1500")
    @Pattern(regexp = "\\d{4}", message = "year should have 4 digits")
    private int year_of_creation;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    @Column(name="taken_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date takenAt;

    @Transient
    private  boolean expired;

    public Book() {
    }

    public Book(String name, String author, int year_of_creation) {
        this.name = name;
        this.author = author;
        this.year_of_creation = year_of_creation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear_of_creation() {
        return year_of_creation;
    }

    public void setYear_of_creation(int year_of_creation) {
        this.year_of_creation = year_of_creation;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Date getTakenAt() {
        return takenAt;
    }

    public void setTakenAt(Date takenAt) {
        this.takenAt = takenAt;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
