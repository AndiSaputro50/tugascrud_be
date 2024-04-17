package com.sekolah.crud.Implements;

import com.sekolah.crud.Dto.KelasDto;
import com.sekolah.crud.Exception.NotFoundException;
import com.sekolah.crud.Model.Kelas;
import com.sekolah.crud.Servicee.KelasService;
import com.sekolah.crud.repository.GuruRepository;
import com.sekolah.crud.repository.KelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KelasImpl implements KelasService {

    @Autowired
    private KelasRepository kelasRepository;

    @Autowired GuruRepository guruRepository;

    @Override
    public Kelas getKelas(Long id) {
        return kelasRepository.findById(id).orElseThrow(() -> new NotFoundException("Id tidak ditemukan"));
    }

    @Override
    public Kelas addKelas(KelasDto kelas) {
        Kelas kelas1 = new Kelas();
        kelas1.setNamaKelas(kelas.getNamaKelas());
        kelas1.setNamaJurusan(kelas.getNamaJurusan());
        kelas1.setGuru(guruRepository.findById(kelas.getGuru()).orElseThrow(() -> new NotFoundException("Id Guru Not Found")));
        return kelasRepository.save(kelas1);
    }

    @Override
    public Kelas editKelas(Long id, KelasDto kelas) {
        Kelas kls = kelasRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found"));
        kls.setNamaKelas(kelas.getNamaKelas());
        kls.setNamaJurusan(kelas.getNamaJurusan());
        kls.setGuru(guruRepository.findById(kelas.getGuru()).orElseThrow(() -> new NotFoundException("Id Guru Not Found")));
        return kelasRepository.save(kls);
    }

    @Override
    public Map<String, Boolean> deleteKelasById(Long id) {
        try {
            kelasRepository.deleteById(id);
            Map<String, Boolean> res = new HashMap<>();
            res.put("deleted", Boolean.TRUE);
            return res;
        } catch (Exception e) {
            throw new NotFoundException("Id Not Found");
        }
    }

    @Override
    public List<Kelas> getAllKelas(String search, Long UserId) {
        return kelasRepository.searchfindAll(search, UserId);
    }


}
