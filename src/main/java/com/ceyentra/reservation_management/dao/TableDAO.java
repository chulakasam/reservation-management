package com.ceyentra.reservation_management.dao;


import com.ceyentra.reservation_management.entity.Restaurant_table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableDAO extends JpaRepository<Restaurant_table,Integer> {
}
