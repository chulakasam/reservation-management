package com.ceyentra.reservation_management.service;

import com.ceyentra.reservation_management.dto.CustomerDTO;
import com.ceyentra.reservation_management.entity.Customer;

import java.util.List;

public interface CustomerService {

    void saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> viewAllCustomers();

    CustomerDTO viewSpecificCustomer(int customer_id);

    void updateCustomer(CustomerDTO customerDTO,int customer_id);
}

