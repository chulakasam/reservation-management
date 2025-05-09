package com.ceyentra.reservation_management.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Time;
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {
    private int restaurant_id;

    private String name;

    private String address;

    private String phone_number;

    private String cuisine_type;

    private Time opening_hours;

    private Time closing_hours;

    private int capacity;

    private String image_url;

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCuisine_type() {
        return cuisine_type;
    }

    public void setCuisine_type(String cuisine_type) {
        this.cuisine_type = cuisine_type;
    }

    public Time getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(Time opening_hours) {
        this.opening_hours = opening_hours;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Time getClosing_hours() {
        return closing_hours;
    }

    public void setClosing_hours(Time closing_hours) {
        this.closing_hours = closing_hours;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
