package com.example.pharmacy.management.model;

import jakarta.persistence.*;
//import org.springframework.data.annotation.Id;

@Entity
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String medicineName;

    private java.time.LocalDate dateOfManufacture; // Use LocalDate for date

    private int Price; // Use double for price with decimals

    public Medicine() {
    }

    public Medicine( Long Id,String medicineName, java.time.LocalDate dateOfManufacture, int price) {
        this.Id = Id;
        this.medicineName = medicineName;
        this.dateOfManufacture = dateOfManufacture;
        this.Price = price;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public java.time.LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(java.time.LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer Price) {
        this.Price = Price;
    }
}


