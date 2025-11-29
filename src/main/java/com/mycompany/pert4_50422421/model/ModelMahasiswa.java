/*
 * Header otomatis dari NetBeans.
 * Biasanya berisi informasi template file atau lisensi.
 */

package com.mycompany.pert4_50422421.model;
// Package model berisi class-class yang mewakili tabel di database.

/*
 * Import anotasi dari Jakarta Persistence (JPA)
 * untuk memetakan class ini menjadi entitas database.
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Class ModelMahasiswa merepresentasikan tabel "mahasiswa" di database.
 * Setiap atribut di class ini mewakili kolom dalam tabel.
 * Class ini akan digunakan oleh Hibernate untuk melakukan operasi CRUD.
 */
@Entity  // Menandai bahwa class ini adalah entitas (tabel) database
@Table(name = "mahasiswa")  // Menentukan nama tabel di database
public class ModelMahasiswa {
    
    // ================== Deklarasi Kolom ==================
    
    @Id  // Menandakan bahwa kolom ini adalah primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Nilai ID akan dibuat otomatis (auto-increment) oleh database
    @Column(name = "id")  // Nama kolom di database adalah "id"
    private int id;
    
    @Column(name = "npm", nullable = false, length = 10)
    // Kolom "npm" tidak boleh null dan maksimal panjangnya 10 karakter
    private String npm;
    
    @Column(name = "nama", nullable = false, length = 50)
    // Kolom "nama" tidak boleh null dan maksimal panjangnya 50 karakter
    private String nama;
    
    @Column(name = "semester", nullable = false, length = 2)
    // Kolom "semester" bertipe integer dan wajib diisi
    private int semester;
    
    @Column(name = "ipk", nullable = false, length = 4)
    // Kolom "ipk" bertipe float dan wajib diisi
    private float ipk;   
    
    // ================== Constructor ==================
    
    public ModelMahasiswa(){
        // Constructor kosong (default) wajib ada untuk Hibernate
    }
    
    // Constructor dengan parameter (memudahkan pembuatan objek secara langsung)
    public ModelMahasiswa(int id, String npm, String nama, int semester, float ipk){
        this.id = id;
        this.npm = npm;
        this.nama = nama;
        this.semester = semester;
        this.ipk = ipk;
    }

    // ================== Getter dan Setter ==================
    // Digunakan untuk mengambil dan mengubah nilai atribut (enkapsulasi).

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public float getIpk() {
        return ipk;
    }

    public void setIpk(float ipk) {
        this.ipk = ipk;
    }
}
