package com.example.poolticketing.controller;

import com.example.poolticketing.dto.AddTicketSalesDto;
import com.example.poolticketing.dto.TicketSalesDto;
import com.example.poolticketing.service.TicketSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket-sales")
public class TicketSalesController {
    @Autowired
    private TicketSalesService ticketSalesService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<String> addSales(@RequestBody AddTicketSalesDto req){
        return ticketSalesService.addSales(req.getQty());
    }

    @GetMapping("/get")
    @ResponseBody
    public ResponseEntity<TicketSalesDto> getSales(){
        return ticketSalesService.getSales();
    }
}
