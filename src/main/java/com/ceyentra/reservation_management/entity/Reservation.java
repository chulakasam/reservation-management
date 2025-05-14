package com.ceyentra.reservation_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private int reservation_id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private Restaurant_table table;

    @Column(name = "reservation_date_time", nullable = false)
    private LocalDateTime reservation_date_time;

    @Column(name = "party_size", nullable = false)
    private int party_size;

    @Column(name = "status")
    private String status = "Pending";

    @Column(name = "special_requests")
    private String special_requests;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "creation_date_time", updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private LocalDateTime creation_date_time;

    @Column(name = "last_modified_date_time")
    @org.hibernate.annotations.UpdateTimestamp
    private LocalDateTime last_modified_date_time;

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant_table getTable() {
        return table;
    }

    public void setTable(Restaurant_table table) {
        this.table = table;
    }

    public LocalDateTime getReservation_date_time() {
        return reservation_date_time;
    }

    public void setReservation_date_time(LocalDateTime reservation_date_time) {
        this.reservation_date_time = reservation_date_time;
    }

    public int getParty_size() {
        return party_size;
    }

    public void setParty_size(int party_size) {
        this.party_size = party_size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecial_requests() {
        return special_requests;
    }

    public void setSpecial_requests(String special_requests) {
        this.special_requests = special_requests;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreation_date_time() {
        return creation_date_time;
    }

    public void setCreation_date_time(LocalDateTime creation_date_time) {
        this.creation_date_time = creation_date_time;
    }

    public LocalDateTime getLast_modified_date_time() {
        return last_modified_date_time;
    }

    public void setLast_modified_date_time(LocalDateTime last_modified_date_time) {
        this.last_modified_date_time = last_modified_date_time;
    }
}
