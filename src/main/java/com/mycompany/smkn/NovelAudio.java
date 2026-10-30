/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smkn;

/**
 *
 * @author Naila Salsa
 */
public class NovelAudio extends Novel implements DapatDiberiRating, DapatDikelola {
    private int durasiMenit;
    private String narator;
    private double rating;
    private boolean sudahDibaca;

    public NovelAudio(String judul, String penulis, String genre, int tahunTerbit,int durasiMenit, String narator) throws Exception {
        super(judul, penulis, genre, tahunTerbit);
        if (tahunTerbit < 1 || tahunTerbit > 2026) {
            throw new Exception("Tahun terbit harus berada pada rentang 1–2026.");
        }
        this.durasiMenit = durasiMenit;
        this.narator = narator;
        this.rating = 0.0;
        this.sudahDibaca = false;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Jenis: Novel Audio");
        System.out.println("Judul: " + getJudul());
        System.out.println("Penulis: " + getPenulis());
        System.out.println("Genre: " + getGenre());
        System.out.println("Tahun Terbit: " + getTahunTerbit());
        System.out.println("Durasi: " + durasiMenit + " menit");
        System.out.println("Narator: " + narator);
        System.out.println("Rating: " + rating);
        System.out.println("Status Dibaca: "
                + (sudahDibaca ? "Sudah" : "Belum"));
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