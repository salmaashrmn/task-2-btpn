package com.example.pembelianbarang.controller;

import com.example.pembelianbarang.service.PembelianBarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barang")
public class PembelianBarangController {
    @Autowired
    private PembelianBarangService pembelianBarangService;

    @PostMapping("/rekomendasi")
    @ResponseBody
    public ResponseEntity<String> rekomendasi(@RequestParam long uang){
        return pembelianBarangService.bestBuy(uang);
    }

}
