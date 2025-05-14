package com.ceyentra.reservation_management.service;

import com.ceyentra.reservation_management.dao.CustomerDAO;
import com.ceyentra.reservation_management.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
