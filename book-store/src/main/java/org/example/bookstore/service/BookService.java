package org.example.bookstore.service;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.dao.BookRepository;
import org.example.bookstore.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }
    public Book findBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }
    public List<Book> findBooksByCategoryOrFeatures(String key){
        return bookRepository.searchByCategoryOrFeatures(key);
    }
}
