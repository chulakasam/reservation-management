package com.ceyentra.reservation_management.service.Impl;

import com.ceyentra.reservation_management.dao.CustomerDAO;
import com.ceyentra.reservation_management.dao.UserDAO;
import com.ceyentra.reservation_management.dto.CustomerDTO;
import com.ceyentra.reservation_management.entity.Customer;
import com.ceyentra.reservation_management.entity.User;
import com.ceyentra.reservation_management.service.CustomerService;
import com.ceyentra.reservation_management.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerDAO customerDAO;
    private Mapping mapping;
    private UserDAO userDAO;
    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO, Mapping mapping, UserDAO userDAO) {
        this.customerDAO = customerDAO;
        this.mapping = mapping;
        this.userDAO = userDAO;

    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        User user = userDAO.findById(customerDTO.getUser_id())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Customer customer = mapping.toCustomerEntity(customerDTO);
        customer.setUser(user); // Attach managed User entity

        customerDAO.save(customer);
    }
}
