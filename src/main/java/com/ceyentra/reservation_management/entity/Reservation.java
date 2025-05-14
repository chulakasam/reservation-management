package com.ceyentra.reservation_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private int reservation_id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
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


}
