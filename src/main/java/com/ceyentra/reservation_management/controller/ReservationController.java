package com.ceyentra.reservation_management.controller;

import com.ceyentra.reservation_management.dto.ReservationDTO;
import com.ceyentra.reservation_management.entity.Reservation;
import com.ceyentra.reservation_management.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
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




}
