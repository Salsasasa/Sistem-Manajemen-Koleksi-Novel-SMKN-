/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smkn;

/**
 *
 * @author Naila Salsa
 */
public class RuangBaca {
    private String namaRuang;
    private int kapasitas;

    public RuangBaca(String namaRuang, int kapasitas) {
        this.namaRuang = namaRuang;
        this.kapasitas = kapasitas;
    }

    public String getNamaRuang() {
        return namaRuang;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void tampilkanInfo() {
        System.out.println("Nama Ruang : " + namaRuang);
        System.out.println("Kapasitas  : " + kapasitas + " orang");
    }
}
