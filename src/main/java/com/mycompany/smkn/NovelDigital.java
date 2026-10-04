/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smkn;

/**
 *
 * @author Naila Salsa
 */
public class NovelDigital extends Novel {
    private String formatFile;
    private double ukuranFile;

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
        System.out.printf("[Novel Digital] Judul: %-15s | Penulis: %-15s | Genre: %-12s | Tahun: %d | Format: %-5s | Ukuran: %.1f MB%n",
            this.getJudul(),
            this.getPenulis(),
            this.getGenre(),
            this.getTahunTerbit(),
            this.formatFile,
            this.ukuranFile
        );
    }
}
