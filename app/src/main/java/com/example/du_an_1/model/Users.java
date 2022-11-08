package com.example.du_an_1.model;

public class Users {
    private String id;
    private String name;
    private int date;
    private String CCCD;
    private String address;
    private String passwork;
    public Users() {
    }

    public Users(String id, String name, int date, String CCCD, String address, String passwork) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.CCCD = CCCD;
        this.address = address;
        this.passwork = passwork;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPasswork() {
        return passwork;
    }

    public void setPasswork(String passwork) {
        this.passwork = passwork;
    }
}
