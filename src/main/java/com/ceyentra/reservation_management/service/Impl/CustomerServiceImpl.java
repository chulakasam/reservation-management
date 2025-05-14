package com.ceyentra.reservation_management.service.Impl;

import com.ceyentra.reservation_management.dao.CustomerDAO;
import com.ceyentra.reservation_management.dto.CustomerDTO;
import com.ceyentra.reservation_management.entity.Customer;
import com.ceyentra.reservation_management.service.CustomerService;
import com.ceyentra.reservation_management.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
