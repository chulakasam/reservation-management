package com.ceyentra.reservation_management.service;

import com.ceyentra.reservation_management.dto.TableDTO;

import java.util.List;

public interface TableService {

    void saveRestaurantTable(TableDTO  tableDTO);

    List<TableDTO> getAllTables();

    TableDTO getSpecificTable(int tableId);

    void updateTable(int tableId, TableDTO tableDTO);


}
