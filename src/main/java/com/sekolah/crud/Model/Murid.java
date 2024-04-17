package com.sekolah.crud.Model;

import javax.persistence.*;

@Entity
@Table(name = "table_murid")
public class Murid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_siswa")
    private String namaSiswa;

    @Column(name = "Tempat_lahir")
    private String tempatLahir;

    @Column(name = "tanggal_lahir")
    private String tanggalLahir;

    @Column(name = "alamat")
    private String alamat;

    @ManyToOne
    @JoinColumn(name = "kelas")
    private Kelas kls;

    public Murid() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaSiswa() {
        return namaSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        this.namaSiswa = namaSiswa;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Kelas getKls() {
        return kls;
    }

    public void setKls(Kelas kls) {
        this.kls = kls;
    }
}
