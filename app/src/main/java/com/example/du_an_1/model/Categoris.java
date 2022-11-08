package com.example.du_an_1.model;

public class Categoris {
    private int id;
    private String name;

    public Categoris() {
    }

    public Categoris(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
