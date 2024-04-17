package com.sekolah.crud.Dto;

import com.sekolah.crud.Model.Kelas;

public class MuridDto {

    private String alamat;
    private String tanggalLahir;
    private String tempatLahir;
    private String namaSiswa;
    private Long kls;

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getNamaSiswa() {
        return namaSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        this.namaSiswa = namaSiswa;
    }

    public Long getKls() {
        return kls;
    }

    public void setKls(Long kls) {
        this.kls = kls;
    }
}
