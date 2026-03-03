package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/author")
    public ResponseEntity<List<Book>> byAuthor(@RequestParam String author) {
        return ResponseEntity.ok(service.getByAuthor(author));
    }

    @GetMapping("/genre")
    public ResponseEntity<Page<Book>> byGenre(
            @RequestParam String genre,
            @RequestParam(defaultValue="0") int page,
            @RequestParam(defaultValue="10") int size) {

        return ResponseEntity.ok(
                service.getByGenre(genre, PageRequest.of(page, size)));
    }

    @GetMapping("/cheaper")
    public ResponseEntity<List<Book>> cheaper(@RequestParam Double maxPrice) {
        return ResponseEntity.ok(service.getCheaper(maxPrice));
    }

    @GetMapping("/expensive")
    public ResponseEntity<List<Book>> expensive(@RequestParam Double minPrice) {
        return ResponseEntity.ok(service.getExpensive(minPrice));
    }

    @GetMapping("/new-arrivals")
    public ResponseEntity<List<Book>> afterDate(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate publishedAfter) {

        return ResponseEntity.ok(service.getAfterDate(publishedAfter));
    }

    @GetMapping("/published-before")
    public ResponseEntity<List<Book>> beforeDate(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date) {

        return ResponseEntity.ok(service.getBeforeDate(date));
    }

    @GetMapping("/price-range")
    public ResponseEntity<List<Book>> priceRange(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice) {

        return ResponseEntity.ok(service.getByPriceRange(minPrice, maxPrice));
    }

    @GetMapping("/latest")
    public ResponseEntity<Page<Book>> latest(
            @RequestParam(defaultValue="0") int page,
            @RequestParam(defaultValue="10") int size,
            @RequestParam(defaultValue="publishDate") String sortBy,
            @RequestParam(defaultValue="desc") String sortDir) {

        return ResponseEntity.ok(
                service.getLatest(page, size, sortBy, sortDir));
    }
}