package com.ceyentra.reservation_management.service;

import com.ceyentra.reservation_management.dao.RestaurantDAO;
import com.ceyentra.reservation_management.dto.RestaurantDTO;
import com.ceyentra.reservation_management.util.Mapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
