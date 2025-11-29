/*
 * Header otomatis dari NetBeans
 * (Menunjukkan file ini dibuat dari template).
 */

package com.mycompany.pert4_50422421.model;
// Package model berisi class-class yang berhubungan dengan data (Model).

import java.util.List;
import javax.swing.table.AbstractTableModel;
// Import:
// - List untuk menyimpan data mahasiswa dalam bentuk list.
// - AbstractTableModel untuk membuat model tabel custom yang bisa digunakan oleh JTable.

/**
 * Class ModelTableMahasiswa adalah model untuk JTable.
 * Fungsinya untuk menampilkan data mahasiswa (ModelMahasiswa)
 * ke dalam tabel GUI di Java Swing.
 */
public class ModelTableMahasiswa extends AbstractTableModel {

    // ===================== Atribut =====================
    private List<ModelMahasiswa> mahasiswaList;
    // List yang berisi kumpulan objek mahasiswa.

    private String[] columnNames = {"ID", "NPM", "Nama", "Semester", "IPK"};
    // Nama-nama kolom yang akan ditampilkan di tabel.

    // ===================== Constructor =====================
    public ModelTableMahasiswa(List<ModelMahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
        // Konstruktor menerima data mahasiswa (List<ModelMahasiswa>)
        // agar bisa ditampilkan di tabel.
    }

    // ===================== Override Method dari AbstractTableModel =====================

    @Override
    public int getRowCount() {
        // Mengembalikan jumlah baris dalam tabel.
        // Setiap baris merepresentasikan satu objek mahasiswa.
        return mahasiswaList.size();
    }

    @Override
    public int getColumnCount() {
        // Mengembalikan jumlah kolom.
        // Berdasarkan jumlah elemen dalam array columnNames.
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Mengambil data yang akan ditampilkan di sel tertentu (baris dan kolom).

        ModelMahasiswa mahasiswa = mahasiswaList.get(rowIndex);
        // Ambil data mahasiswa pada baris ke-rowIndex.

        switch (columnIndex) {
            case 0:
                return mahasiswa.getId();        // Kolom ID
            case 1:
                return mahasiswa.getNpm();       // Kolom NPM
            case 2:
                return mahasiswa.getNama();      // Kolom Nama
            case 3:
                return mahasiswa.getSemester();  // Kolom Semester
            case 4:
                return mahasiswa.getIpk();       // Kolom IPK
            default:
                return null; // Jika kolom tidak dikenal, kembalikan null.
        }
    }

    @Override
    public String getColumnName(int column) {
        // Mengembalikan nama kolom sesuai dengan index kolom.
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // Mengatur apakah sel bisa diedit langsung di tabel.
        // false = semua sel tidak bisa diedit.
        return false;
    }

    // ===================== Method Tambahan =====================

    public void setMahasiswaList(List<ModelMahasiswa> mahasiswaList) {
        // Method ini digunakan untuk memperbarui isi tabel (misalnya setelah CRUD).
        this.mahasiswaList = mahasiswaList;

        // Memberi tahu JTable bahwa data sudah berubah agar tampilan otomatis refresh.
        fireTableDataChanged();
    }
}
