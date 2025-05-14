package com.ceyentra.reservation_management.controller;

import com.ceyentra.reservation_management.dto.TableDTO;
import com.ceyentra.reservation_management.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/table")
public class TableController {
    private TableService tableService;

    @Autowired
    public TableController(TableService tableService) {
        this.tableService = tableService;
    }


    @PostMapping("/add")
    public void AddNewTable(@RequestBody TableDTO tableDTO){
        tableService.saveRestaurantTable(tableDTO);
    }


    @GetMapping("/view")
    public List<TableDTO> getAllTables(){
        return tableService.getAllTables();
    }

    @GetMapping("/view/{table_id}")
    public TableDTO getTable(@PathVariable int table_id){
        return tableService.getSpecificTable(table_id);
    }

    @PutMapping("/update/{table_id}")
    public void updateTable(@PathVariable int table_id, @RequestBody TableDTO tableDTO){
        tableService.updateTable(table_id,tableDTO);
    }

    @DeleteMapping("/delete/{table_id}")
    public void deleteTable(@PathVariable int table_id){
        tableService.deleteTable(table_id);
    }
}
