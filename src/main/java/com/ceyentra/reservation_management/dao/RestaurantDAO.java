package com.ceyentra.reservation_management.dao;

import com.ceyentra.reservation_management.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDAO extends JpaRepository<Restaurant,Integer> {
}
