package com.example.demo;

public class User {

    private int id;
    private String name;
    private String city;

    // Constructor
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    // Getters (VERY IMPORTANT for Thymeleaf)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    // Optional: Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }
}