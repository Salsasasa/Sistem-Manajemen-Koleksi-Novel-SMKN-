/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smkn;

/**
 *
 * @author Naila Salsa
 */
public class NovelAudio extends Novel {
    private int durasiMenit;
    private String narator;
    
    public NovelAudio(String judul, String penulis, String genre,int tahunTerbit, int durasiMenit, String narator) {
        super(judul, penulis, genre, tahunTerbit);
        this.durasiMenit = durasiMenit;
        this.narator = narator;
    }
    
    public int getDurasiMenit() {
        return this.durasiMenit;
    }

    public void setDurasiMenit(int durasiMenit) {
        if (durasiMenit > 0) {
            this.durasiMenit = durasiMenit;
        } else {
            System.out.println("Durasi tidak valid!");
        }
    }

    public String getNarator() {
        return this.narator;
    }

    public void setNarator(String narator) {
        if (narator != null && !narator.isEmpty()) {
            this.narator = narator;
        } else {
            System.out.println("Narator tidak valid!");
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Novel Audio] Judul: %-15s | Penulis: %-15s | Genre: %-12s | Tahun: %d | Durasi: %d menit | Narator: %s%n",
            this.getJudul(),
            this.getPenulis(),
            this.getGenre(),
            this.getTahunTerbit(),
            this.durasiMenit,
            this.narator
        );
    
    }   
}
