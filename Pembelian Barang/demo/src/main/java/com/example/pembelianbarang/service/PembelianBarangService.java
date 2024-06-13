package com.example.pembelianbarang.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PembelianBarangService {
    List<Long> hargaKeyboard = Arrays.asList(30000L, 45000L, 60000L);
    List<Long> hargaMouse = Arrays.asList(12000L, 20000L, 35000L);

    public ResponseEntity<String> bestBuy(long uang) {
        long result = 0;
        for (long keyboard : hargaKeyboard) {
            for (long mouse : hargaMouse) {
                long total = keyboard + mouse;

                if (total <= uang) {
                    result = total;
                }
            }
        }
        return ResponseEntity.ok("Pembelian terbaik yang bisa dilakukan dengan uang " + uang + " adalah: " + result);
    }
}
