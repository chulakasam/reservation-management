package com.ceyentra.reservation_management.service.Impl;

import com.ceyentra.reservation_management.dao.*;
import com.ceyentra.reservation_management.dto.ReservationDTO;
import com.ceyentra.reservation_management.entity.*;
import com.ceyentra.reservation_management.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    private final ReservationDAO reservationDAO;
    private final CustomerDAO customerDAO;
    private final RestaurantDAO restaurantDAO;
    private final TableDAO tableDAO;
    private final UserDAO userDAO;

    @Autowired
    public ReservationServiceImpl(
            ReservationDAO reservationDAO,
            CustomerDAO customerDAO,
            RestaurantDAO restaurantDAO,
            TableDAO tableDAO,
            UserDAO userDAO
    ) {
        this.reservationDAO = reservationDAO;
        this.customerDAO = customerDAO;
        this.restaurantDAO = restaurantDAO;
        this.tableDAO = tableDAO;
        this.userDAO = userDAO;
    }

    @Override
    public void saveNewReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();

        // Fetch related entities
        Customer customer = customerDAO.findById(reservationDTO.getCustomer_id())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Restaurant restaurant = restaurantDAO.findById(reservationDTO.getRestaurant_id())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        Restaurant_table table = tableDAO.findById(reservationDTO.getTable_id())
                .orElseThrow(() -> new RuntimeException("Table not found"));
        User user = userDAO.findById(reservationDTO.getUser_id())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Set fields
        reservation.setCustomer(customer);
        reservation.setRestaurant(restaurant);
        reservation.setTable(table);
        reservation.setReservation_date_time(reservationDTO.getReservation_date_time());
        reservation.setParty_size(reservationDTO.getParty_size());
        reservation.setStatus(reservationDTO.getStatus());
        reservation.setSpecial_requests(reservationDTO.getSpecial_requests());
        reservation.setUser(user);

        // Let JPA handle creation/update timestamps
        reservationDAO.save(reservation);
    }
}
