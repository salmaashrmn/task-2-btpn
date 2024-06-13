package com.example.ayambertelur.controller;

import com.example.ayambertelur.dto.TelurReqDto;
import com.example.ayambertelur.dto.PenghasilanTelurDto;
import com.example.ayambertelur.service.PenghasilanTelurService;
import com.example.ayambertelur.service.TambahTelurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telur")
public class TelurController {
    @Autowired
    private TambahTelurService tambahTelurService;

    @Autowired
    private PenghasilanTelurService penghasilanTelurService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<String> addTelur(@RequestBody TelurReqDto req){
        return tambahTelurService.addTelur(req.getTelurAyam());
    }

    @GetMapping("/penghasilan")
    @ResponseBody
    public ResponseEntity<PenghasilanTelurDto> getPenghasilanTelur(){
        return penghasilanTelurService.penghasilan();
    }
}
