package com.ceyentra.reservation_management.service;

import com.ceyentra.reservation_management.dao.RestaurantDAO;
import com.ceyentra.reservation_management.dto.RestaurantDTO;
import com.ceyentra.reservation_management.entity.Restaurant;
import com.ceyentra.reservation_management.util.Mapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {
    private Mapping mapping;
    private RestaurantDAO restaurantDAO;
    @Autowired
    public RestaurantServiceImpl(RestaurantDAO restaurantDAO, Mapping mapping) {
        this.restaurantDAO = restaurantDAO;
        this.mapping = mapping;
    }

    @Override
    public void saveRestaurant(RestaurantDTO restaurantDTO) {
           restaurantDAO.save(mapping.toRestaurantEntity(restaurantDTO));
    }

    @Override
    public List<RestaurantDTO> getAllRestaurants() {
        List<Restaurant> restaurantList = restaurantDAO.findAll();
        return mapping.asRestaurantDTOList(restaurantList);
    }

    @Override
    public RestaurantDTO getSpecificRestaurant(int restaurantId) {
        Optional<Restaurant> specific_restaurant = restaurantDAO.findById(restaurantId);
        return mapping.toRestaurantDTO(specific_restaurant.get());
    }

    @Override
    public void deleteRestaurant(int restaurantId) {
        Optional<Restaurant> selected_restaurant = restaurantDAO.findById(restaurantId);
        if(selected_restaurant.isPresent()){
            restaurantDAO.deleteById(restaurantId);
        }
    }
}
