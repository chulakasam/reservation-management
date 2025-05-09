package com.ceyentra.reservation_management.util;

import com.ceyentra.reservation_management.dto.RestaurantDTO;
import com.ceyentra.reservation_management.entity.Restaurant;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;

    public Restaurant toRestaurantEntity(RestaurantDTO restaurantDTO){
        return modelMapper.map(restaurantDTO, Restaurant.class);
    }
    public RestaurantDTO toRestaurantDTO(Restaurant restaurantEntity){
        return modelMapper.map(restaurantEntity, RestaurantDTO.class);
    }
    public List<RestaurantDTO> asRestaurantDTOList(List<Restaurant> restaurantList){return modelMapper.map(restaurantList, new TypeToken<List<RestaurantDTO>>(){}.getType());
    }
    public List<Restaurant> toRestaurantEntityList(List<RestaurantDTO> restaurantDTOList) {
        return modelMapper.map(restaurantDTOList,new TypeToken<List<Restaurant>>() {}.getType());
    }


}
