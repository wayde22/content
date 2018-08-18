package com.wadestevens.content.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Inventory {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=2, max=15)
    private String room;

    @NotNull
    @Size(min=2, message = "Item must not be empty")
    private String item;

    @NotNull
    @Size(min=3, message="Description must not be empty")
    private String description;

    @NotNull
    @Size(min=3, max=30)
    private String model;

    @NotNull
//    @Size(min=8, message="Please enter a valid date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purchaseDate;

    private double purchaseValue;

    private double currentValue;

//    @Lob
//    @Column(name="image")
//    private byte[] image;


    public Inventory(String room, String item, String description, String model, Date purchaseDate, double purchaseValue, double currentValue, byte[] image) {
        this.room = room;
        this.item = item;
        this.description = description;
        this.model = model;
        this.purchaseDate = purchaseDate;
        this.purchaseValue = purchaseValue;
        this.currentValue = currentValue;
//        this.image = image;
    }


    public Inventory(){ }

    public int getId() {
        return id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(double purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

//    public byte[] getImage() {
//        return image;
//    }
//
//    public void setImage(byte[] image) {
//        this.image = image;
//    }

}
