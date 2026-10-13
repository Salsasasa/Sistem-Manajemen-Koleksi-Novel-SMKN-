/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smkn;

/**
 *
 * @author Naila Salsa
 */
public class NovelDigital extends Novel implements DapatDiberiRating, DapatDikelola{
    private String formatFile;
    private double ukuranFile;
    private double rating;
    private boolean sudahDibaca;

    public NovelDigital(String judul, String penulis, String genre,int tahunTerbit, String formatFile, double ukuranFile) {
        super(judul, penulis, genre, tahunTerbit);
        this.formatFile = formatFile;
        this.ukuranFile = ukuranFile;
    }

    public String getFormatFile() {
        return this.formatFile;
    }

    public void setFormatFile(String formatFile) {
        if (formatFile != null && !formatFile.isEmpty()) {
            this.formatFile = formatFile;
        } else {
            System.out.println("Format file tidak valid!");
        }
    }

    public double getUkuranFile() {
        return this.ukuranFile;
    }

    public void setUkuranFile(double ukuranFile) {
        if (ukuranFile > 0) {
            this.ukuranFile = ukuranFile;
        } else {
            System.out.println("Ukuran file tidak valid!");
        }
    }

    @Override
    public void tampilkanInfo() {
    System.out.println("Judul          : " + getJudul());
    System.out.println("Penulis        : " + getPenulis());
    System.out.println("Genre          : " + getGenre());
    System.out.println("Tahun Terbit   : " + getTahunTerbit());
    System.out.println("Format File    : " + formatFile);
    System.out.println("Ukuran File    : " + ukuranFile);
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