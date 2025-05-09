package com.ceyentra.reservation_management.util;

import com.ceyentra.reservation_management.dto.RestaurantDTO;
import com.ceyentra.reservation_management.entity.RestaurantEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;

    public RestaurantEntity toRestaurantEntity(RestaurantDTO restaurantDTO){
        return modelMapper.map(restaurantDTO, RestaurantEntity.class);
    }
    public RestaurantDTO toRestaurantDTO(RestaurantEntity restaurantEntity){
        return modelMapper.map(restaurantEntity, RestaurantDTO.class);
    }

}
