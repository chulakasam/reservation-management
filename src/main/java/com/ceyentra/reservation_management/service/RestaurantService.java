package com.ceyentra.reservation_management.service;

import com.ceyentra.reservation_management.dto.RestaurantDTO;

import java.util.List;

public interface RestaurantService {
    void saveRestaurant(RestaurantDTO  restaurantDTO);


    List<RestaurantDTO> getAllRestaurants();
}
