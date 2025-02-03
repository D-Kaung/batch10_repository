package org.example.bookstore.cart;

import org.example.bookstore.entity.Book;
import org.springframework.beans.BeanUtils;

public class CartItemUtil {

    public static CartItem toCartItem(Book book) {
        CartItem cartItem = new CartItem();
        BeanUtils.copyProperties(book, cartItem);
        return cartItem;
    }
}
