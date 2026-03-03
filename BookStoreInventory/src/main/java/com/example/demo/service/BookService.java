package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.repo.BookRepo;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {

    private final BookRepo repo;

    public BookService(BookRepo repo) {
        this.repo = repo;
    }

    private <T> T checkEmpty(T data) {
        if (data instanceof List<?> list && list.isEmpty())
            throw new ResourceNotFoundException("No books found.");
        if (data instanceof Page<?> page && page.isEmpty())
            throw new ResourceNotFoundException("No books found.");
        return data;
    }

    public List<Book> getByAuthor(String author) {
        return checkEmpty(repo.findByAuthor(author));
    }

    public Page<Book> getByGenre(String genre, Pageable pageable) {
        return checkEmpty(repo.findByGenre(genre, pageable));
    }

    public List<Book> getCheaper(Double maxPrice) {
        return checkEmpty(repo.findByPriceLessThan(maxPrice));
    }

    public List<Book> getExpensive(Double minPrice) {
        return checkEmpty(repo.findByPriceGreaterThan(minPrice));
    }

    public List<Book> getAfterDate(LocalDate date) {
        return checkEmpty(repo.findByPublishDateAfter(date));
    }

    public List<Book> getBeforeDate(LocalDate date) {
        return checkEmpty(repo.findByPublishDateBefore(date));
    }

    public List<Book> getByPriceRange(Double min, Double max) {
        return checkEmpty(repo.findByPriceBetween(min, max));
    }

    public Page<Book> getLatest(int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() :
                Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return checkEmpty(repo.findAll(pageable));
    }
}