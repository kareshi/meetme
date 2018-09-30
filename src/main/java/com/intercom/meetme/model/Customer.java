package com.intercom.meetme.model;

import com.google.gson.annotations.SerializedName;

public class Customer {

    @SerializedName("user_id") private int userId;
    private String name;
    private double latitude;
    private double longitude;

    public Customer(int userId, String name, double latitude, double longitude) {
        this.userId = userId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
