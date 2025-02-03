package org.example.bookstore.cart;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@SessionScope
@Service
public class CartService {
    private Set<CartItem> cartItems
            = new HashSet<>();
    public void decreaseItem(long id){
        cartItems = cartItems
                .stream()
                .map( item -> {
                    if(item.getId() == id) {
                        if(item.getQuantity() > 1){
                            item.setQuantity(item.getQuantity() - 1);
                        }
                    }
                    return item;
                })
                .collect(Collectors.toSet());
    }

    public void increaseItem(long id){
        cartItems = cartItems
                .stream()
                .map( item -> {
                    if(item.getId() == id) {
                        item.setQuantity(item.getQuantity() + 1);
                    }
                    return item;
                })
                .collect(Collectors.toSet());
    }


    public void addToCart(CartItem cartItem) {
        cartItems.add(cartItem);
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public int cartSize(){
        return cartItems.size();
    }

    public void removeFromCart(long id) {
       // this.cartItems.removeIf(cartItem -> cartItem.getId() == id);
        this.cartItems= this.cartItems
                .stream()
                .filter(i -> i.getId() != id)
                .collect(Collectors.toSet());
    }

    public void clearCart() {
        this.cartItems.clear();
    }
}
