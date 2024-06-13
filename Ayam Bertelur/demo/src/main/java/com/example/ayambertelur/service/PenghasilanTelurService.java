package com.example.ayambertelur.service;

import com.example.ayambertelur.dto.PenghasilanTelurDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PenghasilanTelurService {
    @Autowired
    private TambahTelurService tambahTelurService;

    private Long hargaPerTelur = 2500L;

    public ResponseEntity<PenghasilanTelurDto> penghasilan() {
        int totalTelur = tambahTelurService.getTotalTelur();
        return ResponseEntity.ok(
                PenghasilanTelurDto.builder()
                        .totalPenghasilan(totalTelur * hargaPerTelur)
                        .totalTelur(totalTelur)
                        .build()
        );
    }
}
