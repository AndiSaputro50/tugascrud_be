package com.sekolah.crud.Dto;

public class KelasDto {

    private String namaKelas;

    private String namaJurusan;

    private Long guru;

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public String getNamaJurusan() {
        return namaJurusan;
    }

    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }

    public Long getGuru() {
        return guru;
    }

    public void setGuru(Long guru) {
        this.guru = guru;
    }
}
