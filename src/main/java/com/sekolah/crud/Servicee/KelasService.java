package com.sekolah.crud.Servicee;

import com.sekolah.crud.Dto.KelasDto;
import com.sekolah.crud.Model.Kelas;

import java.util.List;
import java.util.Map;

public interface KelasService {

    Kelas getKelas(Long id);

    Kelas addKelas(KelasDto kelas);

    Kelas editKelas(Long id, KelasDto kelas);

    Map<String ,Boolean> deleteKelasById(Long id);

    List<Kelas> getAllKelas(String search , Long UserId);

}
