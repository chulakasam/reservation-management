package com.ceyentra.reservation_management.service.Impl;

import com.ceyentra.reservation_management.dao.ReservationDAO;
import com.ceyentra.reservation_management.service.ReservationService;
import com.ceyentra.reservation_management.util.Mapping;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
    private ReservationDAO reservationDAO;
    private Mapping mapping;

    public ReservationServiceImpl(ReservationDAO reservationDAO, Mapping mapping) {
        this.reservationDAO = reservationDAO;
        this.mapping = mapping;
    }


}
