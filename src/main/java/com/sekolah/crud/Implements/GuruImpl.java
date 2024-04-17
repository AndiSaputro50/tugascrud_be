package com.sekolah.crud.Implements;

import com.sekolah.crud.Exception.NotFoundException;
import com.sekolah.crud.Model.Guru;
import com.sekolah.crud.Servicee.GuruService;
import com.sekolah.crud.repository.GuruRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GuruImpl implements GuruService {
    @Autowired
    private GuruRepository guruRepository;

    @Override
    public Guru getGuru(Long id) {
        return guruRepository.findById(id).orElseThrow(() -> new NotFoundException("Id tidak ditemukan"));
    }

    @Override
    public Guru addGuru(Guru guru) {
        guru.setNamaGuru(guru.getNamaGuru());
        guru.setAlamat(guru.getAlamat());
        guru.setTempatLahir(guru.getTempatLahir());
        guru.setTanggalLahir(guru.getTanggalLahir());
        guru.setUmur(guru.getUmur());
        return guruRepository.save(guru);
    }

    @Override
    public Guru editGuru(Long id, Guru guru) {
        Guru mata = guruRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found"));
        mata.setNamaGuru(guru.getNamaGuru());
        mata.setAlamat(guru.getAlamat());
        mata.setTempatLahir(guru.getTempatLahir());
        mata.setTanggalLahir(guru.getTanggalLahir());
        return guruRepository.save(mata);
    }

    @Override
    public Map<String, Boolean> deleteGuruById(Long id) {
        try {
            guruRepository.deleteById(id);
            Map<String, Boolean> res = new HashMap<>();
            res.put("deleted", Boolean.TRUE);
            return res;
        } catch (Exception e) {
            throw new NotFoundException("Id Not Found");
        }
    }

    @Override
    public List<Guru> allGuru() {
        return guruRepository.findAll();
    }
}
