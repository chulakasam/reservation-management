package com.ceyentra.reservation_management.service.Impl;

import com.ceyentra.reservation_management.dao.TableDAO;
import com.ceyentra.reservation_management.dto.TableDTO;
import com.ceyentra.reservation_management.entity.Restaurant_table;
import com.ceyentra.reservation_management.service.TableService;
import com.ceyentra.reservation_management.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<TableDTO> getAllTables() {
        List<Restaurant_table> restaurantTableList = tableDAO.findAll();
        return mapping.asRestaurantTableDTOList(restaurantTableList);
    }

    @Override
    public TableDTO getSpecificTable(int tableId) {
        Optional<Restaurant_table> specificTable = tableDAO.findById(tableId);
        return mapping.toRestaurantTableDTO(specificTable.get());
    }

    @Override
    public void updateTable(int tableId, TableDTO tableDTO) {
        Optional<Restaurant_table> temp_table = tableDAO.findById(tableId);
        if (temp_table.isPresent()) {
            temp_table.get().setTable_number(tableDTO.getTable_number());
            temp_table.get().setCapacity(tableDTO.getCapacity());
            temp_table.get().setTable_type(tableDTO.getTable_type());
            temp_table.get().setRestaurant(tableDTO.getRestaurant());
            tableDAO.save(temp_table.get());
        }
    }

    @Override
    public void deleteTable(int tableId) {
        Optional<Restaurant_table> specific_table = tableDAO.findById(tableId);
        if (specific_table.isPresent()) {
            tableDAO.deleteById(tableId);
        }
    }


}
