package org.example.bookstore.dao;

import org.example.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("""
select b from Book b where b.category = :key or b.features = :key
""")
    List<Book> searchByCategoryOrFeatures(@Param("key") String key);
}
