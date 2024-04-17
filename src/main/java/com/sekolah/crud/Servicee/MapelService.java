package com.sekolah.crud.Servicee;

import com.sekolah.crud.Dto.MapelDto;
import com.sekolah.crud.Model.Mapel;

import java.util.List;
import java.util.Map;

public interface MapelService {

    Mapel getMapel(Long id);

    Mapel addMapel(MapelDto mapel);

    Mapel editMapel(Long id, MapelDto mapel);

    Map<String ,Boolean> deleteMapelById(Long id);

    List<Mapel> allMapel();
}
