/*
 * Ini adalah header otomatis dari NetBeans.
 * Biasanya berisi informasi tentang template atau lisensi file.
 */

package com.mycompany.pert4_50422421.controller;
// Menentukan package tempat file ini berada (package controller).

import com.mycompany.pert4_50422421.model.ModelMahasiswa;
// Mengimpor class ModelMahasiswa dari package model.
// Class ini merepresentasikan data mahasiswa (entitas).

import java.util.List;
// Mengimpor interface List dari Java Collections untuk menampung banyak data mahasiswa.

/**
 * Interface MahasiswaController digunakan untuk mendefinisikan
 * kontrak (aturan) fungsi-fungsi yang harus diimplementasikan oleh
 * class lain yang mengatur logika CRUD (Create, Read, Update, Delete)
 * data mahasiswa.
 */
public interface MahasiswaController {

    // Menambahkan data mahasiswa baru
    public void addMhs(ModelMahasiswa mhs);

    // Mengambil data mahasiswa berdasarkan ID
    public ModelMahasiswa getMhs(int id);

    // Memperbarui data mahasiswa yang sudah ada
    public void updateMhs(ModelMahasiswa mhs);

    // Menghapus data mahasiswa berdasarkan ID
    public void deleteMhs(int id);

    // Mengambil semua data mahasiswa dari database
    public List<ModelMahasiswa> getAllMahasiswa();
}
