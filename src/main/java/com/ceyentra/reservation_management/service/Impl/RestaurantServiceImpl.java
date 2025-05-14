package com.ceyentra.reservation_management.service.Impl;

import com.ceyentra.reservation_management.dao.RestaurantDAO;
import com.ceyentra.reservation_management.dto.RestaurantDTO;
import com.ceyentra.reservation_management.entity.Restaurant;
import com.ceyentra.reservation_management.service.RestaurantService;
import com.ceyentra.reservation_management.util.Mapping;
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

    @Override
    public void updateRestaurant(RestaurantDTO restaurantDTO,int restaurantId) {
        Optional<Restaurant> selected_restaurant = restaurantDAO.findById(restaurantId);
        if(selected_restaurant.isPresent()){
            selected_restaurant.get().setName(restaurantDTO.getName());
            selected_restaurant.get().setAddress(restaurantDTO.getAddress());
            selected_restaurant.get().setPhone_number(restaurantDTO.getPhone_number());
            selected_restaurant.get().setCuisine_type(restaurantDTO.getCuisine_type());
            selected_restaurant.get().setOpening_hours(restaurantDTO.getOpening_hours());
            selected_restaurant.get().setClosing_hours(restaurantDTO.getClosing_hours());
            selected_restaurant.get().setCapacity(restaurantDTO.getCapacity());
            selected_restaurant.get().setDescription(restaurantDTO.getDescription());
            selected_restaurant.get().setImage_url(restaurantDTO.getImage_url());
            restaurantDAO.save(selected_restaurant.get());
        }
    }
}
