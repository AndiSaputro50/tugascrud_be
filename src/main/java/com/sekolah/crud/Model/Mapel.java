package com.sekolah.crud.Model;

import javax.persistence.*;

@Entity
@Table(name = "table_mapel")
public class Mapel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_mapel")
    private String namaMapel;

    @ManyToOne
    @JoinColumn(name = "guru_pengampu")
    private Guru guru;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaMapel() {
        return namaMapel;
    }

    public void setNamaMapel(String namaMapel) {
        this.namaMapel = namaMapel;
    }

    public Guru getGuru() {
        return guru;
    }

    public void setGuru(Guru guru) {
        this.guru = guru;
    }
}
