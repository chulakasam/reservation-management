package com.ceyentra.reservation_management.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "restaurant")
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private int restaurant_id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phone_number;
    @Column(name = "cuisine_type")
    private String cuisine_type;
    @Column(name = "opening_hours")
    private Time opening_hours;
    @Column(name = "closing_hours")
    private Time closing_hours;
    @Column(name = "capacity")
    private int capacity;
    @Column(name = "description")
    private String description;
    @Column(name = "image_url")
    private String image_url;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "restaurant",cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.PERSIST})
    @JsonManagedReference
    private List<Restaurant_table> restaurantTables;


    public List<Restaurant_table> getRestaurantTables() {
        return restaurantTables;
    }

    public void setRestaurantTables(List<Restaurant_table> restaurantTables) {
        this.restaurantTables = restaurantTables;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public Time getClosing_hours() {
        return closing_hours;
    }

    public void setClosing_hours(Time closing_hours) {
        this.closing_hours = closing_hours;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
