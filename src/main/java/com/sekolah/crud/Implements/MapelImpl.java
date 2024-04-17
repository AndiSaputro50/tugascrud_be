package com.sekolah.crud.Implements;

import com.sekolah.crud.Dto.MapelDto;
import com.sekolah.crud.Exception.NotFoundException;
import com.sekolah.crud.Model.Mapel;
import com.sekolah.crud.Servicee.MapelService;
import com.sekolah.crud.repository.GuruRepository;
import com.sekolah.crud.repository.MapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MapelImpl implements MapelService {

    @Autowired
    private MapelRepository mapelRepository;

    @Autowired
    private GuruRepository guruRepository;

    @Override
    public Mapel getMapel(Long id) {
        return mapelRepository.findById(id).orElseThrow(() -> new NotFoundException("Id tidak ditemukan"));
    }

    @Override
    public Mapel addMapel(MapelDto mapel) {
        Mapel mapel1 = new Mapel();
        mapel1.setNamaMapel(mapel.getNamaMapel());
        mapel1.setGuru(guruRepository.findById(mapel.getGuru()).orElseThrow(() -> new NotFoundException("Id Not Found")));
        return mapelRepository.save(mapel1);
    }

    @Override
    public Mapel editMapel(Long id, MapelDto mapel) {
        Mapel mpl = mapelRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found"));
        mpl.setNamaMapel(mapel.getNamaMapel());
        mpl.setGuru(guruRepository.findById(mapel.getGuru()).orElseThrow(() -> new NotFoundException("Id Not Found")));
        return mapelRepository.save(mpl);
    }

    @Override
    public Map<String, Boolean> deleteMapelById(Long id) {
        try {
            mapelRepository.deleteById(id);
            Map<String, Boolean> res = new HashMap<>();
            res.put("deleted", Boolean.TRUE);
            return res;
        } catch (Exception e) {
            throw new NotFoundException("Id Not Found");
        }
    }

    @Override
    public List<Mapel> allMapel() {
        return mapelRepository.findAll();

    }
}
