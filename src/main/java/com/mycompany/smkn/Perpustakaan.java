/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smkn;

import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author Naila Salsa
 */
public class Perpustakaan {
    private String namaPerpustakaan;
    private RuangBaca ruangBaca;

    private ArrayList<Novel> daftarNovel;
    private HashMap<String, Anggota> dataAnggota;

    public Perpustakaan(String namaPerpustakaan) {
        this.namaPerpustakaan = namaPerpustakaan;

        this.ruangBaca = new RuangBaca("Ruang Baca Novel", 20);

        this.daftarNovel = new ArrayList<>();
        this.dataAnggota = new HashMap<>();
    }

    public void bukaPerpustakaan() {
        System.out.println("\n=== " + namaPerpustakaan + " ===");
        System.out.println("Perpustakaan berhasil dibuka.");

        System.out.println("\nInformasi Ruang Baca:");
        ruangBaca.tampilkanInfo();
    }

    public void tambahNovel(Novel novel) {
        daftarNovel.add(novel);
        System.out.println("Novel berhasil ditambahkan.");
    }

    public void lihatSemuaNovel() {
        System.out.println("\n=== DAFTAR KOLEKSI NOVEL ===");

        if (daftarNovel.isEmpty()) {
            System.out.println("Belum ada novel yang tersimpan.");
            return;
        }

        for (int i = 0; i < daftarNovel.size(); i++) {
            System.out.println("\nNovel ke-" + (i + 1));
            daftarNovel.get(i).tampilkanInfo();
        }
    }

    public void tambahAnggota(Anggota anggota) {
        dataAnggota.put(anggota.getNpm(), anggota);
        System.out.println("Anggota berhasil ditambahkan.");
    }

    public Anggota cariAnggota(String npm) {
        return dataAnggota.get(npm);
    }

    public Anggota getAnggota(String npm) {
        return dataAnggota.get(npm);
    }

    public void lihatSemuaAnggota() {
        System.out.println("\n=== DAFTAR ANGGOTA ===");

        if (dataAnggota.isEmpty()) {
            System.out.println("Belum ada anggota.");
            return;
        }

        for (Anggota anggota : dataAnggota.values()) {
            anggota.tampilkanInfo();
            System.out.println("--------------------");
        }
    }

    public Novel getNovelInt(int index) {
        return daftarNovel.get(index);
    }

    public int getJumlahNovel() {
        return daftarNovel.size();
    }
}
