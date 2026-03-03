package com.example.demo.DTO;

import java.time.LocalDate;

public record BookDTO(
	    Long id,
	    String title,
	    String author,
	    String genre,
	    Double price,
	    LocalDate publishDate 
	) {}
