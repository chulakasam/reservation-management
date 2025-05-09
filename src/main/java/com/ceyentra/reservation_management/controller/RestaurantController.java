package com.ceyentra.reservation_management.controller;

import com.ceyentra.reservation_management.dto.RestaurantDTO;
import com.ceyentra.reservation_management.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/restaurant")
public class RestaurantController {

    private RestaurantService restaurantService;
    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/add")
    public void saveRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        restaurantService.saveRestaurant(restaurantDTO);
    }

    @GetMapping("/view")
    public List<RestaurantDTO> getRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/view/{restaurant_id}")
    public RestaurantDTO getRestaurant(@PathVariable("restaurant_id") int restaurant_id) {
        return restaurantService.getSpecificRestaurant(restaurant_id);
    }

    @DeleteMapping("/delete/{restaurant_id}")
    public void deleteRestaurant(@PathVariable("restaurant_id") int restaurant_id) {
       restaurantService.deleteRestaurant(restaurant_id);
    }


}
