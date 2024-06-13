package com.example.reservasirestoran.service;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

@Service
public class HariReservasiService {
    private final Map<DayOfWeek, String> namaHari;

    public HariReservasiService() {
        namaHari = new HashMap<>();
        namaHari.put(DayOfWeek.MONDAY, "Senin");
        namaHari.put(DayOfWeek.TUESDAY, "Selasa");
        namaHari.put(DayOfWeek.WEDNESDAY, "Rabu");
        namaHari.put(DayOfWeek.THURSDAY, "Kamis");
        namaHari.put(DayOfWeek.FRIDAY, "Jumat");
        namaHari.put(DayOfWeek.SATURDAY, "Sabtu");
        namaHari.put(DayOfWeek.SUNDAY, "Minggu");
    }

    public String getNamaHari(DayOfWeek dayOfWeek) {
        return namaHari.get(dayOfWeek);
    }
}
