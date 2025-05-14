package com.ceyentra.reservation_management.util;

import com.ceyentra.reservation_management.dto.*;
import com.ceyentra.reservation_management.entity.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    //     ------------ customer table ----------------

    public Customer toCustomerEntity(CustomerDTO customerDTO){
        return modelMapper.map(customerDTO, Customer.class);
    }

    public CustomerDTO toCustomerDTO(Customer customerEntity){
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }

    public List<CustomerDTO> asCustomerDTOList(List<Customer> customerList){
        return modelMapper.map(customerList, new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    public List<Customer> toCustomerEntityList(List<CustomerDTO> customerDTOList) {
        return modelMapper.map(customerDTOList, new TypeToken<List<Customer>>() {}.getType());
    }

    //      -------- reservation table --------------

    public Reservation toReservationEntity(ReservationDTO reservationDTO){
        return modelMapper.map(reservationDTO, Reservation.class);
    }

    public ReservationDTO toReservationDTO(Reservation reservationEntity){
        return modelMapper.map(reservationEntity, ReservationDTO.class);
    }

    public List<ReservationDTO> asReservationDTOList(List<Reservation> reservationList){
        return modelMapper.map(reservationList, new TypeToken<List<ReservationDTO>>(){}.getType());
    }

    public List<Reservation> toReservationEntityList(List<ReservationDTO> reservationDTOList) {
        return modelMapper.map(reservationDTOList, new TypeToken<List<Reservation>>() {}.getType());
    }



//------------user table -----------------
public User toUserEntity(UserDto userDTO){
    return modelMapper.map(userDTO, User.class);
}
    public UserDto toUserDTO(User userEntity){
        return modelMapper.map(userEntity, UserDto.class);
    }
    public List<UserDto> asUserDTOList(List<User> userEntities) {
        return modelMapper.map(userEntities, new TypeToken<List<UserDto>>() {}.getType());
    }


}
