package com.ceyentra.reservation_management.service.Impl;

import com.ceyentra.reservation_management.dao.CustomerDAO;
import com.ceyentra.reservation_management.dto.CustomerDTO;
import com.ceyentra.reservation_management.entity.Customer;
import com.ceyentra.reservation_management.service.CustomerService;
import com.ceyentra.reservation_management.util.Mapping;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerDAO customerDAO;
    private Mapping mapping;
    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO, Mapping mapping) {
        this.customerDAO = customerDAO;
        this.mapping = mapping;
    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        customerDAO.save(mapping.toCustomerEntity(customerDTO));
    }

    @Override
    public List<CustomerDTO> viewAllCustomers() {
        List<Customer> customerList = customerDAO.findAll();
        return mapping.asCustomerDTOList(customerList);
    }

    @Override
    public CustomerDTO viewSpecificCustomer(int customer_id) {
        System.out.println("Trying to fetch customer with ID: " + customer_id);
        Optional<Customer> optionalCustomer = customerDAO.findById(customer_id);

        if (optionalCustomer.isPresent()) {
            System.out.println("Customer found: " + optionalCustomer.get().getFirst_name());
        } else {
            System.out.println("Customer NOT found!");
        }

        return optionalCustomer.map(mapping::toCustomerDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found with ID: " + customer_id));
    }


}
