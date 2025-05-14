package com.ceyentra.reservation_management.controller;

import com.ceyentra.reservation_management.dto.CustomerDTO;
import com.ceyentra.reservation_management.entity.Customer;
import com.ceyentra.reservation_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public void addCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
    }

    @GetMapping("/view")
    public List<CustomerDTO> viewAllCustomers(){
       return customerService.viewAllCustomers();
    }

    @GetMapping("/view/{customer_id}")
    public CustomerDTO viewCustomer(@PathVariable("customer_id") int customer_id){
        return customerService.viewSpecificCustomer(customer_id);
    }

    @PutMapping("/update/{customer_id}")
    public void updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable("customer_id") int customer_id){
        customerService.updateCustomer(customerDTO,customer_id);
    }

    @DeleteMapping("/delete/{customer_id}")
    public void deleteCustomer(@PathVariable("customer_id") int customer_id){
        customerService.deleteCustomer(customer_id);
    }

}
