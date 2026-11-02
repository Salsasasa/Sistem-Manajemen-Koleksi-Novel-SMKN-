/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smkn;

/**
 *
 * @author Naila Salsa
 */
public class TransaksiPeminjaman {
    public void prosesPinjam(Anggota anggota, Novel novel) {
        System.out.println("\n=== TRANSAKSI PEMINJAMAN NOVEL ===");

        System.out.println("Data Anggota:");
        System.out.println("NPM  : " + anggota.getNpm());
        System.out.println("Nama : " + anggota.getNama());

        System.out.println("\nData Novel:");
        novel.tampilkanInfo();

        System.out.println("\nTransaksi berhasil diproses.");
    }
}
