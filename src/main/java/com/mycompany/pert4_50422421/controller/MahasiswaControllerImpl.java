/*
 * Ini adalah header otomatis dari NetBeans.
 * Biasanya berisi informasi template atau lisensi file.
 */

package com.mycompany.pert4_50422421.controller;
// Package controller berisi logika pengendali (controller) dari aplikasi.

import com.mycompany.pert4_50422421.model.HibernateUtil;
// Mengimpor class HibernateUtil, yaitu class helper untuk mengatur koneksi Hibernate.

import com.mycompany.pert4_50422421.model.ModelMahasiswa;
// Mengimpor class ModelMahasiswa yang merepresentasikan entitas/tabel "mahasiswa" di database.

import java.util.List;
// Mengimpor interface List dari Java Collections Framework.

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
// Mengimpor class dari Hibernate untuk melakukan operasi database (Session, Transaction, Query).

/**
 * Class MahasiswaControllerImpl merupakan implementasi dari interface MahasiswaController.
 * Di dalamnya terdapat kode untuk menjalankan operasi CRUD (Create, Read, Update, Delete)
 * pada tabel Mahasiswa menggunakan Hibernate.
 */
public class MahasiswaControllerImpl implements MahasiswaController {

    @Override
    public void addMhs(ModelMahasiswa mhs){
        // Method untuk menambahkan data mahasiswa baru ke database.
        Transaction trx = null; // Objek untuk mengatur transaksi database.

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            // Membuka session baru untuk berkomunikasi dengan database.

            trx = session.beginTransaction(); // Memulai transaksi.
            session.save(mhs); // Menyimpan (INSERT) data mahasiswa ke tabel.
            trx.commit(); // Menyimpan perubahan (commit) ke database.
        } catch (Exception e){
            if (trx != null){
                trx.rollback(); // Jika terjadi error, batalkan transaksi.
            }
            e.printStackTrace(); // Menampilkan error di console.
        }
    }

    @Override
    public void updateMhs(ModelMahasiswa mhs) {
        // Method untuk memperbarui (UPDATE) data mahasiswa.
        Transaction trx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            trx = session.beginTransaction(); // Memulai transaksi.
            session.update(mhs); // Melakukan update data mahasiswa berdasarkan ID.
            trx.commit(); // Commit hasil perubahan ke database.
        } catch (Exception e){
            if (trx != null){
                trx.rollback(); // Batalkan transaksi jika terjadi error.
            }
            e.printStackTrace(); // Tampilkan pesan error.
        }
    }

    @Override
    public void deleteMhs(int id) {
        // Method untuk menghapus (DELETE) data mahasiswa berdasarkan ID.
        Transaction trx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            trx = session.beginTransaction(); // Memulai transaksi.

            // Mengambil data mahasiswa berdasarkan ID
            ModelMahasiswa mhs = session.get(ModelMahasiswa.class, id);

            if (mhs != null){
                session.delete(mhs); // Hapus data jika ditemukan.
                System.out.println("Berhasil hapus");
            }

            trx.commit(); // Commit hasil penghapusan.
        } catch (Exception e){
            if (trx != null){
                trx.rollback(); // Batalkan transaksi jika error.
            }
            e.printStackTrace(); // Tampilkan error di console.
        }
    }

    @Override
    public List<ModelMahasiswa> getAllMahasiswa() {
        // Method untuk mengambil semua data mahasiswa dari database.
        Transaction trx = null;
        List<ModelMahasiswa> listMhs = null; // Menampung hasil query.

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            trx = session.beginTransaction();

            // Menggunakan HQL (Hibernate Query Language) untuk mengambil semua data mahasiswa.
            Query<ModelMahasiswa> query = session.createQuery("from ModelMahasiswa", ModelMahasiswa.class);

            listMhs = query.list(); // Menyimpan hasil query ke dalam list.

            trx.commit(); // Commit transaksi.
        } catch (Exception e) {
            if (trx != null) {
                trx.rollback(); // Batalkan transaksi jika error.
            }
            e.printStackTrace(); // Tampilkan error di console.
        }

        return listMhs; // Mengembalikan daftar mahasiswa yang diambil dari database.
    }

    @Override
    public ModelMahasiswa getMhs(int id) {
        // Method ini belum diimplementasikan.
        throw new UnsupportedOperationException("Not supported yet.");
        // Akan digunakan nanti untuk mengambil data mahasiswa berdasarkan ID tertentu.
    }
}