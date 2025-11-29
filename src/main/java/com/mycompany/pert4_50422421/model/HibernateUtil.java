/*
 * Header otomatis dari NetBeans
 * Menunjukkan bahwa file ini dibuat dari template NetBeans.
 */

package com.mycompany.pert4_50422421.model;
// Package model biasanya berisi class yang berhubungan dengan data atau konfigurasi database.

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
// Mengimpor class dari Hibernate:
// - SessionFactory: digunakan untuk membuat session (koneksi ke database).
// - Session: digunakan untuk melakukan operasi (CRUD) pada database.
// - Configuration: digunakan untuk membaca file konfigurasi hibernate.cfg.xml.

/**
 * Class HibernateUtil digunakan untuk mengatur dan menyediakan
 * koneksi (SessionFactory) ke database menggunakan Hibernate.
 * 
 * Class ini biasanya bersifat singleton (hanya ada satu SessionFactory
 * selama aplikasi berjalan) agar efisien dan tidak membebani memori.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory; 
    // SessionFactory adalah objek utama Hibernate untuk membuat koneksi ke database.

    static {
        try {
            // Bagian static block akan dijalankan sekali ketika class pertama kali di-load.

            // Membuat SessionFactory dengan membaca pengaturan dari file hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Menangkap error jika konfigurasi gagal.
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
            // Melempar error fatal agar aplikasi berhenti jika Hibernate gagal terinisialisasi.
        }
    }

    // Method untuk mengembalikan SessionFactory yang sudah dibuat
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Method tambahan untuk mengetes apakah koneksi ke database berhasil
    public static void testConnection() {
        try (Session session = sessionFactory.openSession()) {
            // Membuka session baru ke database
            System.out.println("Connection to the database was successful!");
        } catch (Exception e) {
            // Jika gagal, tampilkan pesan error
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}
