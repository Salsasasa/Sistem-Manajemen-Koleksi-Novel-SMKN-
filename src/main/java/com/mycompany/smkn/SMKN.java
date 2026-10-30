/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.smkn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Naila Salsa
 */
public class SMKN {

    public static void cariNovel(String judul, ArrayList<Novel> daftarNovel) throws Exception {

        System.out.println("Mencari Novel dengan Judul: " + judul);
        boolean ditemukan = false;

        for (int i = 0; i < daftarNovel.size(); i++) {
            if (daftarNovel.get(i).getJudul()
                    .equalsIgnoreCase(judul)) {

                daftarNovel.get(i).tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            throw new Exception("Novel dengan judul '" + judul + "' tidak ditemukan di sistem.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Novel> daftarNovel = new ArrayList<>();
        HashMap<String, String> dataAnggota = new HashMap<>();

        boolean isRunning = true;

        System.out.println("=============================================");
        System.out.println(" SISTEM MANAJEMEN KOLEKSI NOVEL (SMKN) ");
        System.out.println("=============================================");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Novel");
            System.out.println("2. Lihat Daftar Novel");
            System.out.println("3. Cari Novel (Custom Exception)");
            System.out.println("4. Kelola Rating dan Status Baca");
            System.out.println("5. Manajemen Anggota (HashMap)");
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

                        System.out.print("Masukkan Judul: ");
                        String judul = scanner.nextLine();

                        System.out.print("Masukkan Penulis: ");
                        String penulis = scanner.nextLine();

                        System.out.print("Masukkan Genre: ");
                        String genre = scanner.nextLine();

                        System.out.print("Masukkan Tahun Terbit: ");
                        int tahun = scanner.nextInt();
                        scanner.nextLine();

                        Novel novelBaru;

                        if (jenis == 1) {
                            System.out.print("Jumlah Halaman: ");
                            int halaman = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Kondisi Novel: ");
                            String kondisi = scanner.nextLine();

                            novelBaru = new NovelFisik(
                                judul, penulis, genre, tahun,
                                halaman, kondisi
                            );

                        } else if (jenis == 2) {
                            System.out.print("Ukuran File (MB): ");
                            double ukuran = scanner.nextDouble();
                            scanner.nextLine();

                            System.out.print("Format File: ");
                            String format = scanner.nextLine();

                            novelBaru = new NovelDigital(
                                judul, penulis, genre, tahun,
                                format, ukuran
                            );

                        } else if (jenis == 3) {
                            System.out.print("Durasi Audio (menit): ");
                            int durasi = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Nama Narator: ");
                            String narator = scanner.nextLine();

                            novelBaru = new NovelAudio(
                                judul, penulis, genre, tahun,
                                durasi, narator
                            );

                        } else {
                            throw new Exception("Jenis novel harus dipilih dari 1 sampai 3.");
                        }

                        daftarNovel.add(novelBaru);

                        System.out.println("Sukses! Novel berhasil ditambahkan.");
                        System.out.println("Total novel dalam daftar: " + daftarNovel.size());
                    }

                    case 2 -> {
                        System.out.println("\n--- Daftar Koleksi Novel ---");

                        if (daftarNovel.isEmpty()) {
                            System.out.println("Belum ada novel yang tersimpan.");
                        } else {
                            for (int i = 0;
                                 i < daftarNovel.size(); i++) {

                                System.out.print((i + 1) + ". ");
                                daftarNovel.get(i).tampilkanInfo();
                            }

                            System.out.println("Total novel dalam daftar: " + daftarNovel.size());
                        }
                    }

                    case 3 -> {
                        System.out.println("\n--- Fitur Cari Novel ---");
                        System.out.print("Masukkan Judul: ");
                        String kataKunci = scanner.nextLine();

                        try {
                            cariNovel(kataKunci, daftarNovel);
                        } catch (KoleksiTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        } finally {
                            System.out.println("Sesi pencarian selesai dieksekusi.");
                        }
                    }

                    case 4 -> {
                        if (daftarNovel.isEmpty()) {
                            System.out.println("Belum ada novel. Tambahkan novel terlebih dahulu.");
                            break;
                        }

                        System.out.println("\n--- Kelola Rating dan Status Baca ---");

                        for (int i = 0; i < daftarNovel.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            daftarNovel.get(i).tampilkanInfo();
                        }

                        System.out.print("Pilih nomor novel yang akan dikelola: ");
                        int nomor = scanner.nextInt();
                        scanner.nextLine();

                        if (nomor < 1 || nomor > daftarNovel.size()) {
                            throw new Exception("Nomor novel tidak tersedia.");
                        }

                        Novel novel = daftarNovel.get(nomor - 1);

                        System.out.println("\nNovel dipilih: " + novel.getJudul());
                        System.out.println("1. Beri Rating");
                        System.out.println("2. Tandai Sudah Dibaca");
                        System.out.println("3. Tandai Belum Dibaca");
                        System.out.println("4. Lihat Rating dan Status Baca");
                        System.out.print("Pilih tindakan: ");

                        int tindakan = scanner.nextInt();
                        scanner.nextLine();

                        switch (tindakan) {
                            case 1 -> {
                                if (novel instanceof DapatDiberiRating) {
                                    System.out.print("Masukkan rating (0-5): ");
                                    double rating = scanner.nextDouble();
                                    scanner.nextLine();

                                    if (rating < 0 || rating > 5) {
                                        throw new IllegalArgumentException("Rating harus antara 0 sampai 5.");
                                    }

                                    DapatDiberiRating objekRating =
                                        (DapatDiberiRating) novel;

                                    objekRating.beriRating(rating);

                                    System.out.println("Rating berhasil diberikan.");
                                    System.out.println("Rating saat ini: " + objekRating.getRating());
                                } else {
                                    System.out.println("Novel ini tidak mendukung fitur rating.");
                                }
                            }

                            case 2 -> {
                                if (novel instanceof DapatDikelola) {
                                    DapatDikelola statusBaca =
                                        (DapatDikelola) novel;

                                    statusBaca.tandaiDibaca();
                                    System.out.println("Novel ditandai sudah dibaca.");
                                } else {
                                    System.out.println("Novel ini tidak mendukung status baca.");
                                }
                            }

                            case 3 -> {
                                if (novel instanceof DapatDikelola) {
                                    DapatDikelola statusBaca =
                                        (DapatDikelola) novel;

                                    statusBaca.tandaiBelumDibaca();
                                    System.out.println("Novel ditandai belum dibaca.");
                                } else {
                                    System.out.println("Novel ini tidak mendukung status baca.");
                                }
                            }

                            case 4 -> {
                                if (novel instanceof DapatDiberiRating) {
                                    DapatDiberiRating objekRating =
                                        (DapatDiberiRating) novel;

                                    System.out.println("Rating: " + objekRating.getRating()
                                    );
                                } else {
                                    System.out.println("Fitur rating tidak tersedia.");
                                }

                                if (novel instanceof DapatDikelola) {
                                    DapatDikelola statusBaca =
                                        (DapatDikelola) novel;

                                    System.out.println("Status baca: " + (statusBaca.isSudahDibaca() ? "Sudah dibaca" : "Belum dibaca"));
                                } else {
                                    System.out.println("Fitur status baca tidak tersedia.");
                                }
                            }

                            default -> System.out.println("Pilihan tindakan tidak valid.");
                        }
                    }

                    case 5 -> {
                        System.out.println("\n--- Manajemen Anggota (HashMap) ---");
                        System.out.println("1. Tambah Anggota");
                        System.out.println("2. Cari Anggota via NPM");
                        System.out.println("3. Tampilkan Semua Anggota");
                        System.out.print("Pilih: ");

                        int menuAnggota = scanner.nextInt();
                        scanner.nextLine();

                        if (menuAnggota == 1) {
                            System.out.print("Masukkan NPM: ");
                            String npm = scanner.nextLine().trim();

                            System.out.print("Masukkan Nama Lengkap: ");
                            String nama = scanner.nextLine().trim();

                            if (npm.isEmpty() || nama.isEmpty()) {
                                throw new Exception("NPM dan nama tidak boleh kosong.");
                            }

                            if (dataAnggota.containsKey(npm)) {
                                throw new Exception("NPM sudah terdaftar.");
                            }

                            dataAnggota.put(npm, nama);
                            System.out.println("Anggota berhasil ditambahkan.");

                        } else if (menuAnggota == 2) {
                            System.out.print("Masukkan NPM yang dicari: ");
                            String cariNpm = scanner.nextLine().trim();

                            if (dataAnggota.containsKey(cariNpm)) {
                                System.out.println("Nama anggota: " + dataAnggota.get(cariNpm));
                            } else {
                                System.out.println("Anggota tidak ditemukan.");
                            }

                        } else if (menuAnggota == 3) {
                            System.out.println("Total anggota: " + dataAnggota.size());

                            for (String npm : dataAnggota.keySet()) {
                                System.out.println("NPM: " + npm + " | Nama: " + dataAnggota.get(npm));
                            }

                        } else {
                            System.out.println("Pilihan menu anggota tidak valid." );
                        }
                    }

                    case 6 -> {
                        System.out.println("Terima kasih telah menggunakan SMKN!" );
                        isRunning = false;
                    }

                    default -> System.out.println("Pilihan menu tidak valid.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR INPUT] Masukkan angka dengan format yang benar.");
                scanner.nextLine();

            } catch (KoleksiTidakDitemukanException e) {
                System.out.println("\n[ERROR DATA] " + e.getMessage());

            } catch (IllegalArgumentException e) {
                System.out.println("\n[ERROR INPUT] " + e.getMessage());

            } catch (Exception e) {
                System.out.println("\n[ERROR SISTEM] " + e.getMessage());

            } finally {
                System.out.println("Proses menu selesai ditangani.");
            }
        }

        scanner.close();
    }
}

