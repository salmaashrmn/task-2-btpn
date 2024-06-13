package com.example.ayambertelur.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TambahTelurService {
    private int totalTelur = 0;

    public ResponseEntity<String> addTelur(int quantity) {
        totalTelur += quantity;

        return ResponseEntity.ok("Jumlah telur berhasil ditambahkan: " + quantity);
    }

    public int getTotalTelur() {
        return totalTelur;
    }
}
