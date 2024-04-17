package com.sekolah.crud.Servicee;

import com.sekolah.crud.Dto.MuridDto;
import com.sekolah.crud.Model.Murid;

import java.util.List;
import java.util.Map;

public interface MuridService {

    Murid getSiswa(Long id);

    Murid addSiswa(MuridDto siswa);

    Murid editSiswa(Long id,MuridDto siswa);

    Map<String ,Boolean> deleteSiswaById(Long id);

    List<Murid> allMurid();

}
