package com.ceyentra.reservation_management.service;

import com.ceyentra.reservation_management.dto.RestaurantDTO;

import java.util.List;

public interface RestaurantService {
    void saveRestaurant(RestaurantDTO  restaurantDTO);


    List<RestaurantDTO> getAllRestaurants();

    RestaurantDTO getSpecificRestaurant(int restaurantId);

    void deleteRestaurant(int restaurantId);

    void updateRestaurant(RestaurantDTO  restaurantDTO,int restaurantId);
}
