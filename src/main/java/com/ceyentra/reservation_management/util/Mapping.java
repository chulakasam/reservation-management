package com.ceyentra.reservation_management.util;

import com.ceyentra.reservation_management.dto.RestaurantDTO;
import com.ceyentra.reservation_management.dto.TableDTO;
import com.ceyentra.reservation_management.entity.Restaurant;
import com.ceyentra.reservation_management.entity.Restaurant_table;
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



//    -------------- restaurant table -----------

    public Restaurant_table toRestaurantTableEntity(TableDTO tableDTO){
        return modelMapper.map(tableDTO, Restaurant_table.class);
    }

    public TableDTO toRestaurantTableDTO(Restaurant_table restaurant_tableEntity){
        return modelMapper.map(restaurant_tableEntity, TableDTO.class);
    }

    public List<TableDTO> asRestaurantTableDTOList(List<Restaurant_table> restaurant_tablesList){
        return modelMapper.map(restaurant_tablesList, new TypeToken<List<TableDTO>>(){}.getType());
    }

    public List<Restaurant_table> toRestaurantTableEntityList(List<TableDTO> tableDTOList) {
        return modelMapper.map(tableDTOList, new TypeToken<List<Restaurant_table>>() {}.getType());
    }








}
