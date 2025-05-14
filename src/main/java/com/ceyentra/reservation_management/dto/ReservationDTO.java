package com.ceyentra.reservation_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor

public class ReservationDTO {

    private int reservation_id;
    private int customer_id;
    private int restaurant_id;
    private int table_id;
    private LocalDateTime reservation_date_time;
    private int party_size;
    private String status;
    private String special_requests;
    private Integer user_id;
    private Timestamp creation_date_time;
    private Timestamp last_modified_date_time;
}
