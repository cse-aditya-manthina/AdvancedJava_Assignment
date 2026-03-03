package com.example.demo.repo;

import com.example.demo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);
    Page<Book> findByGenre(String genre, Pageable pageable);
    List<Book> findByPriceLessThan(Double price);
    List<Book> findByPriceGreaterThan(Double price);
    List<Book> findByPublishDateAfter(LocalDate date);
    List<Book> findByPublishDateBefore(LocalDate date);
    List<Book> findByTitleContaining(String keyword);
    List<Book> findByTitleStartingWith(String prefix);
    List<Book> findByTitleEndingWith(String suffix);
    List<Book> findByGenreAndAuthor(String genre, String author);
    List<Book> findByGenreOrAuthor(String genre, String author);
    List<Book> findByPriceBetween(Double minPrice, Double maxPrice);
    List<Book> findByGenreAndPriceLessThan(String genre, Double price);
}