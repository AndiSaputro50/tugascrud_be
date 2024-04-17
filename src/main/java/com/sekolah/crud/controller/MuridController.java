package com.sekolah.crud.controller;

import com.sekolah.crud.Auth.Response.CommonResponse;
import com.sekolah.crud.Auth.Response.ResponseHelper;
import com.sekolah.crud.Dto.MuridDto;
import com.sekolah.crud.Model.Murid;
import com.sekolah.crud.Servicee.MuridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/siswa")
public class MuridController {

    @Autowired
    MuridService muridService;

    @GetMapping("/{id}") //untuk melihat sesaui id
    public CommonResponse<Murid> getSiswaById(@PathVariable("id")Long id) {
        return ResponseHelper.ok(muridService.getSiswa(id)) ;
    }

    @PostMapping // untuk mengepost data
    public CommonResponse<Murid> addSiswa(@RequestBody MuridDto muridDto) {
        return ResponseHelper.ok(muridService.addSiswa(muridDto));
    }

    @PutMapping("/{id}") // untuk mengedit data sesuai id
    public CommonResponse<Murid> editMuridById(@PathVariable("id") Long id, @RequestBody MuridDto murid) {
        return ResponseHelper.ok(muridService.editSiswa(id, murid));
    }

    @DeleteMapping("/{id}") // untuk menghapus data sesuai id
    public CommonResponse <?> deleteMuridById(@PathVariable("id") Long id) {
        return ResponseHelper.ok(muridService.deleteSiswaById(id));}

    @GetMapping("/all-murid")
    public CommonResponse<List<Murid>> allMurid() {
        return ResponseHelper.ok(muridService.allMurid());
    }

}
