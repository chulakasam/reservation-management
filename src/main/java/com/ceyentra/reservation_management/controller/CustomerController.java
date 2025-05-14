package com.ceyentra.reservation_management.controller;

import com.ceyentra.reservation_management.service.CustomerService;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/v1/customer")
public class CustomerController {
    private CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


}
