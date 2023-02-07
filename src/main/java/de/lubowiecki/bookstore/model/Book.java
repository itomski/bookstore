package de.lubowiecki.bookstore.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
public class Book {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2") // Generator wird ausgewählt
    @GeneratedValue(generator = "uuid2") // Gewählte Generator wird benutzt
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String title;

    @NotEmpty
    @Size(min = 2, max = 1000)
    private String description;
    @NotEmpty
    @Size(min = 2, max = 50)
    private String author;

    @NotEmpty
    @Size(min = 2, max = 25)
    private String isbn;

    @Positive
    private double price;

    public Book() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
