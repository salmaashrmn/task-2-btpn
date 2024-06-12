package com.example.poolticketing.service;

import com.example.poolticketing.dto.TicketSalesDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TicketSalesService {
    private long hargaTiket = 20000;
    private long totalPenjualan = 0;
    private int totalTiket = 0;

    public ResponseEntity<String> addSales(int qty){
        long totalTransaksi = ((long) qty) * hargaTiket;
        totalPenjualan += totalTransaksi;
        totalTiket += qty;

        return ResponseEntity.ok("Penjualan berhasil ditambahkan. Total: Rp." + totalPenjualan);
    }

    public ResponseEntity<TicketSalesDto> getSales(){
        return ResponseEntity.ok(
                TicketSalesDto.builder()
                        .totalPenjualan(totalPenjualan)
                        .totalTiket(totalTiket)
                        .build()
        );
    }
}
