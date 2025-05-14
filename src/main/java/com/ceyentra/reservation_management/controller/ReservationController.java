package com.ceyentra.reservation_management.controller;

import com.ceyentra.reservation_management.dto.ReservationDTO;
import com.ceyentra.reservation_management.entity.Reservation;
import com.ceyentra.reservation_management.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/reservation")
public class ReservationController {
    private ReservationService  reservationService;
    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> createNewReservation(@RequestBody ReservationDTO reservationDTO) {
        try {
            reservationService.saveNewReservation(reservationDTO);
            return ResponseEntity.ok("Reservation created successfully.");
        } catch (RuntimeException e) {
            // Custom error handling can be added here
            return ResponseEntity.status(400).body("Error creating reservation: " + e.getMessage());
        }
    }

}
