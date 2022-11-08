package com.example.du_an_1.model;

public class Orders {
    private int id;
    private int user_id;
    private int vehicle_id;
    private int start_time;
    private int end_time;
    private int total;
    private int phatsinh;

    public Orders() {
    }

    public Orders(int id, int user_id, int vehicle_id, int start_time, int end_time, int total, int phatsinh) {
        this.id = id;
        this.user_id = user_id;
        this.vehicle_id = vehicle_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.total = total;
        this.phatsinh = phatsinh;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }



    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getEnd_time() {
        return end_time;
    }

    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPhatsinh() {
        return phatsinh;
    }

    public void setPhatsinh(int phatsinh) {
        this.phatsinh = phatsinh;
    }
}
