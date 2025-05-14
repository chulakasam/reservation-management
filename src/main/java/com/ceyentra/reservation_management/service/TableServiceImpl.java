package com.ceyentra.reservation_management.service;

import com.ceyentra.reservation_management.dao.TableDAO;
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

}
