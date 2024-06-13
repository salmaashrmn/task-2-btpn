package com.example.reservasirestoran.controller;

import com.example.reservasirestoran.service.ReservasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservasi")
public class ReservasiController {
    @Autowired
    private ReservasiService reservasiService;

    @PostMapping("/tambah")
    public ResponseEntity<String> tambahReservasi(@RequestParam String nama) {
        return ResponseEntity.ok(reservasiService.tambahReservasi(nama));
    }

    @GetMapping("/")
    public ResponseEntity<String> dapatkanJadwalMingguan() {
        return ResponseEntity.ok(reservasiService.getJadwalMingguan());
    }
}
