package com.sekolah.crud.Implements;

import com.sekolah.crud.Dto.MuridDto;
import com.sekolah.crud.Exception.InternalErrorException;
import com.sekolah.crud.Exception.NotFoundException;
import com.sekolah.crud.Model.Guru;
import com.sekolah.crud.Model.Murid;
import com.sekolah.crud.Servicee.MuridService;
import com.sekolah.crud.repository.KelasRepository;
import com.sekolah.crud.repository.MuridRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MuridImpl implements MuridService {

    @Autowired
    private MuridRepository muridRepository;

    @Autowired
    private KelasRepository kelasRepository;

    @Override
    public Murid getSiswa(Long id) {
        return muridRepository.findById(id).orElseThrow(() -> new InternalErrorException("Id Not Found"));
    }

    @Override
    public Murid addSiswa(MuridDto siswa) {
        Murid murid = new Murid();
        murid.setNamaSiswa(siswa.getNamaSiswa());
        murid.setAlamat(siswa.getAlamat());
        murid.setTempatLahir(siswa.getTempatLahir());
        murid.setTanggalLahir(siswa.getTanggalLahir());
        murid.setKls(kelasRepository.findById(siswa.getKls()).orElseThrow(() -> new NotFoundException("Id Not Found")));
        return muridRepository.save(murid);
    }

    @Override
    public Murid editSiswa(Long id, MuridDto siswa) {
        Murid murid = muridRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found"));
        murid.setNamaSiswa(siswa.getNamaSiswa());
        murid.setAlamat(siswa.getAlamat());
        murid.setTempatLahir(siswa.getTempatLahir());
        murid.setTanggalLahir(siswa.getTanggalLahir());
        murid.setKls(kelasRepository.findById(siswa.getKls()).orElseThrow(() -> new NotFoundException("Id Not Found")));
        return muridRepository.save(murid);
    }

    @Override
    public Map<String, Boolean> deleteSiswaById(Long id) {
        try {
            muridRepository.deleteById(id);
            Map<String, Boolean> res = new HashMap<>();
            res.put("deleted", Boolean.TRUE);
            return res;
        } catch (Exception e) {
            throw new NotFoundException("Id Not Found");
        }
    }

    @Override
    public List<Murid> allMurid() {
        return muridRepository.findAll();
    }
}
