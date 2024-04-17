package com.sekolah.crud.Servicee;

import com.sekolah.crud.Model.Guru;

import java.util.List;
import java.util.Map;

public interface GuruService {

    Guru getGuru(Long id);

    Guru addGuru(Guru guru);

    Guru editGuru(Long id,Guru guru);

    Map<String ,Boolean> deleteGuruById(Long id);

    List<Guru> allGuru();

}
