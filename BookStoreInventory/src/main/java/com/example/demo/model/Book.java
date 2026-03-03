package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String author;
	private String genre;
	private Double price;
	private LocalDate publish_Date;
	/**
	 * 
	 */
	public Book() {
		
	}
	/**
	 * @param id
	 * @param title
	 * @param author
	 * @param genre
	 * @param price
	 * @param publishDate
	 */
	public Book(Long id, String title, String author, String genre, Double price, LocalDate publish_Date) {
		
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.price = price;
		this.publish_Date = publish_Date;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the publishDate
	 */
	public LocalDate getPublishDate() {
		return publish_Date;
	}
	/**
	 * @param publishDate the publishDate to set
	 */
	public void setPublishDate(LocalDate publishDate) {
		this.publish_Date = publishDate;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", genre=" + genre + ", price=" + price
				+ ", publishDate=" + publish_Date + "]";
	}
	
	
	
	
	
	
	

}
