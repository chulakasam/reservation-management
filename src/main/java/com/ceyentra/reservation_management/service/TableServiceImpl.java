package com.ceyentra.reservation_management.service;

import com.ceyentra.reservation_management.dao.TableDAO;
import com.ceyentra.reservation_management.dto.TableDTO;
import com.ceyentra.reservation_management.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TableServiceImpl implements TableService {
    private TableDAO tableDAO;
    private Mapping mapping;

    @Autowired
    public TableServiceImpl(TableDAO tableDAO, Mapping mapping) {
        this.tableDAO = tableDAO;
        this.mapping = mapping;
    }


    @Override
    public void saveRestaurantTable(TableDTO tableDTO){
        if (tableDTO == null) {
            throw new IllegalArgumentException("TableDTO must not be null");
        }
        tableDAO.save(mapping.toRestaurantTableEntity(tableDTO));
    }




}
