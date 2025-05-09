package com.ceyentra.reservation_management.service;

import com.ceyentra.reservation_management.dao.RestaurantDAO;
import com.ceyentra.reservation_management.dto.RestaurantDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {
    private ModelMapper modelMapper;
    private RestaurantDAO restaurantDAO;
    @Autowired
    public RestaurantServiceImpl(RestaurantDAO restaurantDAO, ModelMapper modelMapper) {
        this.restaurantDAO = restaurantDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    public RestaurantDTO saveRestaurant(RestaurantDTO restaurantDTO) {

    }
}
