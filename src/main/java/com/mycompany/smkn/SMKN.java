/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.smkn;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Naila Salsa
 */
public class SMKN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Perpustakaan perpusNovel = new Perpustakaan("Koleksi Novel Lavender");
        perpusNovel.bukaPerpustakaan();

        boolean isRunning = true;

        System.out.println("=============================================");
        System.out.println("            SELAMAT DATANG DI SMKN           ");
        System.out.println("=============================================");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Koleksi Novel");
            System.out.println("2. Lihat Daftar Koleksi Novel");
            System.out.println("3. Cari Novel");
            System.out.println("4. Manajemen Anggota");
            System.out.println("5. Peminjaman Novel (Demo Association)");
            System.out.println("6. Keluar");
            System.out.print("Pilih Menu (1-6): ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    
                    case 1 -> {
                        System.out.println("\n--- Pilih Jenis Novel ---");
                        System.out.println("1. Novel Fisik");
                        System.out.println("2. Novel Digital");
                        System.out.println("3. Novel Audio");
                        System.out.print("Pilih jenis (1-3): ");
                        
                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        if (jenis < 1 || jenis > 3) {
                            System.out.println("Pilihan jenis novel tidak valid!");
                            break;
                        }

                        System.out.print("Masukkan Judul: ");
                        String judul = scanner.nextLine();

                        System.out.print("Masukkan Penulis: ");
                        String penulis = scanner.nextLine();

                        System.out.print("Masukkan Genre: ");
                        String genre = scanner.nextLine();

                        System.out.print("Masukkan Tahun Terbit: ");
                        int tahun = scanner.nextInt();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Jumlah Halaman: ");
                            int halaman = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Masukkan Kondisi Novel: ");
                            String kondisi = scanner.nextLine();

                            perpusNovel.tambahNovel(
                                new NovelFisik(judul, penulis, genre, tahun, halaman, kondisi)
                            );

                        } else if (jenis == 2) {
                            System.out.print("Masukkan Format File: ");
                            String formatFile = scanner.nextLine();

                            System.out.print("Masukkan Ukuran File (MB): ");
                            double ukuranFile = scanner.nextDouble();
                            scanner.nextLine();

                            perpusNovel.tambahNovel(new NovelDigital(judul, penulis, genre, tahun, formatFile, ukuranFile));

                        } else if (jenis == 3) {
                            System.out.print("Masukkan Durasi (menit): ");
                            int durasi = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Masukkan Nama Narator: ");
                            String narator = scanner.nextLine();

                            perpusNovel.tambahNovel(new NovelAudio(judul, penulis, genre, tahun, durasi, narator));
                        }

                        System.out.println("Sukses! Novel berhasil ditambahkan. (Total Novel: " + perpusNovel.getJumlahNovel() + ")");
                    }

                    case 2 -> {
                        System.out.println("\n--- Daftar Koleksi Novel ---");
                        perpusNovel.lihatSemuaNovel();
                    }

                    case 3 -> {
                        System.out.println("\n--- Fitur Cari Novel ---");
                        System.out.print("Masukkan Judul Novel: ");
                        String kataKunci = scanner.nextLine();

                        boolean ditemukan = false;

                        for (int i = 0; i < perpusNovel.getJumlahNovel(); i++) {
                            Novel novel = perpusNovel.getNovelInt(i);

                            if (novel.getJudul().equalsIgnoreCase(kataKunci)) {
                                System.out.println("\nNovel ditemukan:");
                                novel.tampilkanInfo();
                                ditemukan = true;
                            }
                        }

                        if (!ditemukan) {
                            System.out.println("Novel dengan judul \"" + kataKunci + "\" tidak ditemukan.");
                        }
                    }

                    case 4 -> {
                        System.out.println("\n-- Kelola Anggota --");
                        System.out.println("1. Tambah Anggota");
                        System.out.println("2. Cari Anggota");
                        System.out.println("3. Lihat Semua Anggota");
                        System.out.print("Pilih: ");
                        int menuA = scanner.nextInt();
                        scanner.nextLine();

                        if (menuA == 1) {
                            System.out.print("Masukkan NPM: ");
                            String npm = scanner.nextLine();

                            System.out.print("Masukkan Nama: ");
                            String nama = scanner.nextLine();

                            perpusNovel.tambahAnggota(new Anggota(npm, nama));

                        } else if (menuA == 2) {
                            System.out.print("NPM yang dicari: ");
                            String npm = scanner.nextLine();

                            Anggota anggota = perpusNovel.cariAnggota(npm);

                            if (anggota != null) {
                                System.out.println("\nAnggota ditemukan:");
                                anggota.tampilkanInfo();
                            } else {
                                System.out.println(
                                    "Anggota dengan NPM tersebut tidak ditemukan."
                                );
                            }

                        } else if (menuA == 3) {
                            perpusNovel.lihatSemuaAnggota();

                        } else {
                            System.out.println("Pilihan menu anggota tidak valid!");
                        }
                    }

                    case 5 -> {
                        System.out.println("\n-- Sistem Peminjaman (Association) --");
                        System.out.print("Masukkan NPM Peminjam: ");
                        String inputNpm = scanner.nextLine();

                        Anggota peminjam = perpusNovel.getAnggota(inputNpm);

                        if (peminjam == null) {
                            System.out.println("Gagal: Anggota belum terdaftar!");

                        } else if (perpusNovel.getJumlahNovel() == 0) {
                            System.out.println("Gagal: Belum ada novel yang bisa dipinjam.");

                        } else {
                            perpusNovel.lihatSemuaNovel();

                            System.out.print("Pilih Nomor Novel yang ingin dipinjam: ");
                            int noNovel = scanner.nextInt() - 1;
                            scanner.nextLine();

                            if (noNovel >= 0 && noNovel < perpusNovel.getJumlahNovel()) {
                                Novel novelDipinjam = perpusNovel.getNovelInt(noNovel);

                                TransaksiPeminjaman transaksi = new TransaksiPeminjaman();
                                transaksi.prosesPinjam(peminjam, novelDipinjam);

                            } else {
                                System.out.println("Nomor novel tidak valid!");
                            }
                        }
                    }

                    case 6 -> {
                        System.out.println("Terima kasih telah menggunakan SMKN!");
                        isRunning = false;
                    }

                    default -> System.out.println("Pilihan tidak valid.");
                }

            } catch (InputMismatchException e) {
                System.out.println(
                    "\n[ERROR INPUT] Input tidak valid! Masukkan angka sesuai petunjuk."
                );
                scanner.nextLine();

            } catch (Exception e) {
                System.out.println(
                    "\n[ERROR SISTEM] Terjadi kesalahan: " + e.getMessage()
                );
            }
        }

        scanner.close();
    }
}

