/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smkn;

/**
 *
 * @author Naila Salsa
 */
public class NovelFisik extends Novel {
    private int jumlahHalaman;
    private String kondisi;

    public NovelFisik(String judul, String penulis, String genre, int tahunTerbit, int jumlahHalaman, String kondisi) {
        super(judul, penulis, genre, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.kondisi = kondisi;
    }

    // getter jumlah halaman
    public int getJumlahHalaman() {
        return this.jumlahHalaman;
    }

    // setter jumlah halaman
    public void setJumlahHalaman(int jumlahHalaman) {
        if (jumlahHalaman > 0) {
            this.jumlahHalaman = jumlahHalaman;
        } else {
            System.out.println("Jumlah halaman tidak valid!");
        }
    }

    // getter kondisi
    public String getKondisi() {
        return this.kondisi;
    }

    // Setter kondisi
    public void setKondisi(String kondisi) {
        if (kondisi != null && !kondisi.isEmpty()) {
            this.kondisi = kondisi;
        } else {
            System.out.println("Kondisi novel tidak valid!");
        }
    }

    // overriding method dari Novel
    @Override
    public void tampilkanInfo() {
        System.out.printf("[Novel Fisik] Judul: %-15s | Penulis: %-15s | Genre: %-10s | Tahun: %d | Halaman: %d | Kondisi: %s%n",
            this.getJudul(),
            this.getPenulis(),
            this.getGenre(),
            this.getTahunTerbit(),
            this.jumlahHalaman,
            this.kondisi
        );
    }
}
