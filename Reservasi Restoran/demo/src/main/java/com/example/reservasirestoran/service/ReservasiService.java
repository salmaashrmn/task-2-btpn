package com.example.reservasirestoran.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

@Service
public class ReservasiService {
    @Autowired
    private HariReservasiService hariReservasiService;

    private final Map<DayOfWeek, List<String>> reservasi = new HashMap<>();
    private final Set<DayOfWeek> hariLibur = new HashSet<>(Arrays.asList(DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY));
    private final int maxReservasiPerHari = 2;

    public ReservasiService() {
        for (DayOfWeek hari : DayOfWeek.values()) {
            reservasi.put(hari, new ArrayList<>());
        }
    }

    public String tambahReservasi(String nama) {
        for (DayOfWeek hari : DayOfWeek.values()) {
            if (!hariLibur.contains(hari) && reservasi.get(hari).size() < maxReservasiPerHari) {
                reservasi.get(hari).add(nama);
                return "Reservasi berhasil untuk " + nama + " pada hari " + hariReservasiService.getNamaHari(hari);
            }
        }
        return "Reservasi penuh untuk minggu ini.";
    }

    public String getJadwalMingguan() {
        StringBuilder jadwal = new StringBuilder();
        LocalDate hariIni = LocalDate.now();

        for (int i = 0; i < 7; i++) {
            LocalDate tanggal = hariIni.plusDays(i);
            DayOfWeek hari = tanggal.getDayOfWeek();

            jadwal.append(hariReservasiService.getNamaHari(hari)).append(" (").append(tanggal).append("): ");

            if (hariLibur.contains(hari)) {
                jadwal.append("Libur\n");
            } else {
                List<String> reservasiHari = reservasi.get(hari);
                if (reservasiHari.isEmpty()) {
                    jadwal.append("Tidak ada reservasi\n");
                } else {
                    jadwal.append(String.join(", ", reservasiHari)).append("\n");
                }
            }
        }

        return jadwal.toString();
    }
}
