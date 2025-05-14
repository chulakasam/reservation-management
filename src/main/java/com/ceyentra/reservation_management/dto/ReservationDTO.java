package com.ceyentra.reservation_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationDTO {

    private int reservationId;
    private int customerId;
    private int restaurantId;
    private int tableId;
    private LocalDateTime reservationDateTime;
    private int partySize;
    private String status;
    private String specialRequests;
    private Integer userId;
    private Timestamp creationDateTime;
    private Timestamp lastModifiedDateTime;
}
