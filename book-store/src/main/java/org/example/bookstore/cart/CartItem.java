package org.example.bookstore.cart;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class CartItem {
    private Long id;
    private String title;
    private String author;
    private double price;
    private String features;
    private String category;
    private String imageUrl;
    private int quantity=1;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartItem cartItem)) return false;
        return Objects.equals(getId(), cartItem.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
