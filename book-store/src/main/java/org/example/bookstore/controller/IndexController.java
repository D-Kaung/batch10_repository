package org.example.bookstore.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class IndexController {
	
    private final BookService bookService;
    @GetMapping("/")
    public String indexPage(Model model){
        model.addAttribute("books",
                bookService.findAllBooks());
        return "index";
    }
}
