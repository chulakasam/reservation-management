package com.ceyentra.reservation_management.service;

import com.ceyentra.reservation_management.dao.TableDAO;
import com.ceyentra.reservation_management.dto.TableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TableServiceImpl implements TableService {
    private TableDAO tableDAO;

    @Autowired
    public TableServiceImpl(TableDAO tableDAO) {
        this.tableDAO = tableDAO;
    }


    public void saveRestaurantTable(TableDTO  tableDTO){

    }



}
