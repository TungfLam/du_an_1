package com.example.du_an_1.model;

public class Vehicle {
    private int id;
    private int categorie_id;
    private int capacity;
    private int status;
    private int amount;
    private int price;

    public Vehicle() {
    }


    public Vehicle(int id, int categorie_id, int capacity, int status, int amount, int price) {
        this.id = id;
        this.categorie_id = categorie_id;
        this.capacity = capacity;
        this.status = status;
        this.amount = amount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
