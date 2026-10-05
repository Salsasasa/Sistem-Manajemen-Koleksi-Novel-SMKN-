/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.smkn;
import java.util.Scanner;

/**
 *
 * @author Naila Salsa
 */
public class SMKN {
    // METHOD PROSES
    public static void prosesNovel(Novel novel) {
        System.out.println("\n--- Informasi Novel ---");
        novel.tampilkanInfo();
    }
    
     // method overloading (pencarian 1): parameter string
    public static void cariNovel(String judul, Novel[] daftarNovel, int jumlahNovel) {
        System.out.println("Mencari novel dengan Judul: " + judul);

        boolean ditemukan = false;

        for (int i = 0; i < jumlahNovel; i++) {
            if (daftarNovel[i].getJudul().equalsIgnoreCase(judul)) {
                
                daftarNovel[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Novel tidak ditemukan.");
        }
    }
    
    // method overloading (pencarian 2): nama sama, tetapi parameter int
    public static void cariNovel(int tahunTerbit, Novel[] daftarNovel, int jumlahNovel) {
        System.out.println("Mencari novel dengan Tahun Terbit: " + tahunTerbit);

        boolean ditemukan = false;

        for (int i = 0; i < jumlahNovel; i++) {
            if (daftarNovel[i].getTahunTerbit() == tahunTerbit) {
                System.out.print("- Ditemukan: ");
                daftarNovel[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Novel tidak ditemukan.");
        }
    }

    public static void main(String[] args) {           
        try (Scanner scanner = new Scanner(System.in)) {
            // array untuk menyimpan input novel
            Novel[] daftarNovel = new Novel[10];
            
            int jumlahNovel = 0;
            boolean isRunning = true;
            
            System.out.println("############################");
            System.out.println("   SELAMAT DATANG DI SMKN   ");
            System.out.println("############################");
            
            while (isRunning) {
                System.out.println("\n Menu Utama");
                System.out.println("1. Tambah Koleksi Novel");
                System.out.println("2. Lihat Daftar Novel");
                System.out.println("3. Cari Novel ");
                System.out.println("4. Keluar");
                System.out.print("Pilih Menu (1-4): ");
                
                int pilihan = scanner.nextInt();
                scanner.nextLine();
                
                switch (pilihan) {
                    case 1 -> {
                        if (jumlahNovel < daftarNovel.length) {
                            
                            System.out.println("\n-- Pilih Jenis Novel --");
                            System.out.println("1. Novel Fisik");
                            System.out.println("2. Novel Digital");
                            System.out.println("3. Novel Audio");
                            System.out.print("Pilihan (1/2/3): ");
                            
                            int jenis = scanner.nextInt();
                            scanner.nextLine();
                            
                            if (jenis == 1 || jenis == 2 || jenis == 3) {
                                
                                System.out.print("Masukkan Judul Novel: ");
                                String judulBaru = scanner.nextLine();
                                
                                System.out.print("Masukkan Nama Penulis: ");
                                String penulisBaru = scanner.nextLine();
                                
                                System.out.print("Masukkan Genre: ");
                                String genreBaru = scanner.nextLine();
                                
                                System.out.print("Masukkan Tahun Terbit: ");
                                int tahunBaru = scanner.nextInt();
                                scanner.nextLine();
                                
                                // novel fisik
                                if (jenis == 1) {
                                    System.out.print("Masukkan Jumlah Halaman: ");
                                    int jumlahHalaman = scanner.nextInt();
                                    scanner.nextLine();
                                    
                                    System.out.print("Masukkan Kondisi Novel: ");
                                    String kondisi = scanner.nextLine();
                                    
                                    Novel novelBaru = new NovelFisik(judulBaru, penulisBaru, genreBaru, tahunBaru, jumlahHalaman, kondisi);
                                    
                                    daftarNovel[jumlahNovel] = novelBaru;
                                // novel digital
                                } else if (jenis == 2) {
                                    System.out.print("Masukkan Format File: ");
                                    String formatFile = scanner.nextLine();
                                    
                                    System.out.print("Masukkan Ukuran File (MB): ");
                                    double ukuranFile = scanner.nextDouble();
                                    scanner.nextLine();
                                    
                                    Novel novelBaru = new NovelDigital(judulBaru, penulisBaru, genreBaru, tahunBaru, formatFile, ukuranFile);
                                    daftarNovel[jumlahNovel] = novelBaru;
                                } else if (jenis == 3) {
                                    System.out.print("Masukkan Durasi Audio (menit): ");
                                    int durasiMenit = scanner.nextInt();
                                    scanner.nextLine();
                                    
                                    System.out.print("Masukkan Nama Narator: ");
                                    String narator = scanner.nextLine();
                                    
                                    Novel novelBaru = new NovelAudio(judulBaru, penulisBaru, genreBaru, tahunBaru, durasiMenit, narator);
                                    daftarNovel[jumlahNovel] = novelBaru;
                                }
                                
                                jumlahNovel++;
                                
                                System.out.println("\nSukses! Novel berhasil " + "ditambahkan");
                            } else {
                                System.out.println("Jenis novel tidak valid.");
                            }
                        } else {
                            System.out.println("Maaf, kapasitas koleksi " + "novel sudah penuh!");
                        }
                    }
                    // tampilkan semua novel
                    case 2 -> {
                        System.out.println("\n--- DAFTAR KOLEKSI NOVEL ---");
                    
                        if (jumlahNovel == 0) {
                            System.out.println("Belum ada novel yang tersimpan");
                        } else {
                            for (int i = 0; i < jumlahNovel; i++){
                                System.out.println("\nNovel ke-" + (i + 1));
                                
                                daftarNovel[i].tampilkanInfo();
                                
                                System.out.println("############################");
                            }
                            // variabel statik
                            System.out.println("\nTotal Novel yang Terdatar: " + Novel.totalNovelBerhasilDibuat);
                        }             
                    System.out.print("\nTekan Enter untuk melanjutkan...");
                    scanner.nextLine();    
                    }   
                    // cari novel
                    case 3 -> {
                        System.out.println("\n-- Fitur Cari Novel --");
                        System.out.println("1. Cari berdasarkan Judul (String)");
                        System.out.println("2. Cari berdasarkan Tahun Terbit (Integer)");
                        System.out.print("Pilih (1/2): ");

                        int modeCari = scanner.nextInt();
                        scanner.nextLine();

                        if (modeCari == 1) {

                            System.out.print("Masukkan Judul: ");
                            String kataKunci = scanner.nextLine();

                            cariNovel(kataKunci, daftarNovel, jumlahNovel);

                        } else if (modeCari == 2) {

                            System.out.print("Masukkan Tahun: ");
                            int angkaKunci = scanner.nextInt();
                            scanner.nextLine();

                            cariNovel(angkaKunci, daftarNovel, jumlahNovel);

                        } else {

                            System.out.println("Pilihan tidak valid.");
                        }

                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }  
                    // keluar
                    case 4 -> {
                        System.out.println("Terima kasih telah menggunakan " + "Sistem Manajemen Koleksi Novel!");

                        isRunning = false;
                    }
                    // pilihan tidak valid
                    default -> {

                        System.out.println("Pilihan tidak valid. " + "Silakan masukkan angka 1-4.");

                        scanner.nextLine();
                    }
                }
            }
        }     
    }
}
