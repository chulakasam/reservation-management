package com.ceyentra.reservation_management.dao;

import com.ceyentra.reservation_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
