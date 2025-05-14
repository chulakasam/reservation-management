package com.ceyentra.reservation_management.dao;

import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableDAO extends JpaRepository<Table,Integer> {
}
