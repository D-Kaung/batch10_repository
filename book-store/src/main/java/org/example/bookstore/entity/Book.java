package org.example.bookstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private double price;
    private String features;
    private String category;
    private String imageUrl;

    public Book(String title, String author, double price, String features, String category, String imageUrl) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.features = features;
        this.category = category;
        this.imageUrl = imageUrl;
    }
}
