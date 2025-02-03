package org.example.bookstore.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.cart.CartItem;
import org.example.bookstore.cart.CartItemUtil;
import org.example.bookstore.cart.CartService;
import org.example.bookstore.entity.Book;
import org.example.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final CartService cartService;

    @GetMapping("/increase-item/{id}")
    public String increaseItem(@PathVariable("id") long id){
        cartService.increaseItem(id);
        return "redirect:/books/view-cart";
    }
    @GetMapping("/decrease-item")
    public String decreaseItem(@RequestParam("id")long id){
        cartService.decreaseItem(id);
        return "redirect:/books/view-cart";
    }

    @GetMapping("/view-cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems",cartService
                .getCartItems());
        return "cart-view";
    }

    @GetMapping("/add-cart")
    public String addToCart(@RequestParam("id")long id){
        Book book = bookService.findBookById(id);
        cartService.addToCart(CartItemUtil.toCartItem(book));
        return "redirect:/books";
    }
    @ModelAttribute("cartSize")
    public int cartSize(){
        return cartService.cartSize();
    }
    @GetMapping("/remove-from-cart")
    public String removeFromCart(@RequestParam("id")long id){
        cartService.removeFromCart(id);
        return "redirect:/books/view-cart";
    }
    @GetMapping("/clear-cart")
    public String clearCart(){
        cartService.clearCart();
        return "redirect:/books/view-cart";
    }
    @PostMapping("/search-book")
    public String searchBook(@RequestParam("key")String key,Model model){
        model.addAttribute("books",bookService
                .findBooksByCategoryOrFeatures(key));
        return "books";
    }
    @ModelAttribute("totalPrice")
    public double totalPrice(){
        return cartService
                .getCartItems()
                .stream()
                .mapToDouble( i -> i.getPrice() * i.getQuantity())
                .sum();
    }

    @GetMapping
    public String listAllBooks(Model model) {
        model.addAttribute("books",bookService
                .findAllBooks());
        return "books";
    }
}
