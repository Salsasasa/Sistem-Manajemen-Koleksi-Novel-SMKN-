/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smkn;

/**
 *
 * @author Naila Salsa
 */
public class Novel {
    private String judul;
    private String penulis;
    private String genre;
    private int tahunTerbit;

    public static int totalNovelBerhasilDibuat = 0;

    public Novel(String judul, String penulis, String genre, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.genre = genre;
        this.tahunTerbit = tahunTerbit;
        totalNovelBerhasilDibuat++;
    }

    public String getJudul() {
        return this.judul;
    }

    public void setJudul(String judul) {
        if (judul != null && !judul.isEmpty()) {
            this.judul = judul;
        } else {
            System.out.println("Judul tidak valid!");
        }
    }

    public String getPenulis() {
        return this.penulis;
    }

    public void setPenulis(String penulis) {
        if (penulis != null && !penulis.isEmpty()) {
            this.penulis = penulis;
        } else {
            System.out.println("Penulis tidak valid!");
        }
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        if (genre != null && !genre.isEmpty()) {
            this.genre = genre;
        } else {
            System.out.println("Genre tidak valid!");
        }
    }

    public int getTahunTerbit() {
        return this.tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        if (tahunTerbit > 0) {
            this.tahunTerbit = tahunTerbit;
        } else {
            System.out.println("Tahun terbit tidak valid!");
        }
    }

    public void tampilkanInfo() {
        System.out.printf("Judul: %-15s | Penulis: %-15s | Genre: %-12s | Tahun: %d%n",
            this.judul,
            this.penulis,
            this.genre,
            this.tahunTerbit
        );
    }
}
