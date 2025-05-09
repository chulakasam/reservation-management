package com.ceyentra.reservation_management.dao;

import com.ceyentra.reservation_management.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDAO extends JpaRepository<RestaurantEntity,Integer> {
}
