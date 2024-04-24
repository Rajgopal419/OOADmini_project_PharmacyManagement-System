package com.example.pharmacy.management.model;

public class Admin {
    private String name;
    private String email;

    // Private constructor to prevent instantiation from outside
    private Admin() {
        this.name = "Rajgopal";
        this.email = "admin@example.com";
    }

    // Static variable to hold the single instance of Admin
    private static Admin instance = null;

    // Static method to get the single instance of Admin
    public static Admin getInstance() {
        if (instance == null) {
            instance = new Admin();
        }
        return instance;
    }

    // Getters and setters for name and email properties
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
