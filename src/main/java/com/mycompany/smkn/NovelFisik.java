/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smkn;

/**
 *
 * @author Naila Salsa
 */
public class NovelFisik extends Novel implements DapatDiberiRating, DapatDikelola{
    private int jumlahHalaman;
    private String kondisi;
    private double rating;
    private boolean sudahDibaca;

    public NovelFisik(String judul, String penulis, String genre, int tahunTerbit, int jumlahHalaman, String kondisi) throws Exception{
        super(judul, penulis, genre, tahunTerbit);
        if (tahunTerbit < 1 || tahunTerbit > 2026) {
            throw new Exception("Tahun terbit harus berada pada rentang 1–2026.");
        }
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

    @Override
    public void tampilkanInfo() {
    System.out.println("Judul          : " + getJudul());
    System.out.println("Penulis        : " + getPenulis());
    System.out.println("Genre          : " + getGenre());
    System.out.println("Tahun Terbit   : " + getTahunTerbit());
    System.out.println("Jumlah Halaman : " + jumlahHalaman);
    System.out.println("Kondisi        : " + kondisi);
    System.out.println("Rating         : " + rating);
    System.out.println("Status Baca    : " + (sudahDibaca ? "Sudah Dibaca" : "Belum Dibaca"));
    }
    
    @Override
    public void beriRating(double rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("Rating harus antara 1 sampai 5.");
        }
    }

    @Override
    public double getRating() {
        return rating;
    }

    @Override
    public void tandaiDibaca() {
        sudahDibaca = true;
    }

    @Override
    public void tandaiBelumDibaca() {
        sudahDibaca = false;
    }

    @Override
    public boolean isSudahDibaca() {
        return sudahDibaca;
    }
   
}
