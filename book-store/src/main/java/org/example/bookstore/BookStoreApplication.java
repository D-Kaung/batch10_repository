package org.example.bookstore;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.dao.BookRepository;
import org.example.bookstore.entity.Book;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class BookStoreApplication {
    private final BookRepository bookRepository;
//public Book(String title, String author, double price, String features, String category, String imageUrl) {
    @Bean @Transactional @Profile("dev")
    public ApplicationRunner init() {
        return args -> {
            bookRepository.searchByCategoryOrFeatures("bestseller")
                    .forEach(System.out::println);
            Book book1=new Book("the psychology of money","morgan housel",120,"bestseller","non-fiction","product-item1");
            Book book2=new Book("the two towers","J.R.R Tolkien",50,"novels","fiction","product-item2");
            Book book3=new Book("goal planner","IKIGLOO",25,"bestseller","non-fiction","product-item3");
            Book book4=new Book("stupore e tremori","amelie nothomb",30,"french","non-fiction","product-item4");
            Book book5=new Book("the diary of ann frank","ann frank",60,"bestseller","non-fiction","product-item5");
            Book book6=new Book("Company of One","Paul Jarvis",180,"bestseller","non-fiction","product-item6");
            Book book7=new Book("twisted love","ana haung",50,"bestseller","fiction","product-item7");
            Book book8=new Book("the new testament biblical theology","G.K Beale",100,"bestseller","theology","product-item8");
            Book book9=new Book("your heart is the sea","NIKITA GILL",60,"bestseller","fiction","product-item9");
            Book book10=new Book("how to stop worrying and start living","Dale Carnegie",50,"bestseller","non-fiction","product-item10");
            Book book11=new Book("all the letters i should have sent","rania nain",30,"bestseller","fiction","product-item11");
            Book book12=new Book("progress not perfection","harper manson",60,"bestseller","non-fiction","product-item12");

//            bookRepository.save(book1);
//            bookRepository.save(book2);
//            bookRepository.save(book3);
//            bookRepository.save(book4);
//            bookRepository.save(book5);
//            bookRepository.save(book6);
//            bookRepository.save(book7);
//            bookRepository.save(book8);
//            bookRepository.save(book9);
//            bookRepository.save(book10);
//            bookRepository.save(book11);
//            bookRepository.save(book12);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

}
