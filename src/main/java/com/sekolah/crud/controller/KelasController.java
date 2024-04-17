package com.sekolah.crud.controller;


import com.sekolah.crud.Auth.Response.CommonResponse;
import com.sekolah.crud.Auth.Response.ResponseHelper;
import com.sekolah.crud.Dto.KelasDto;
import com.sekolah.crud.Model.Kelas;
import com.sekolah.crud.Servicee.KelasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kelas")
public class KelasController {

    @Autowired
    KelasService kelasService;

    @GetMapping("/{id}") //untuk melihat sesaui id
    public CommonResponse<Kelas> getKelasById(@PathVariable("id")Long id) {
        return ResponseHelper.ok(kelasService.getKelas(id)) ;
    }

    @PostMapping // untuk mengepost data
    public CommonResponse<Kelas> addKelas(@RequestBody KelasDto kelas) {
        return ResponseHelper.ok(kelasService.addKelas(kelas));
    }

    @PutMapping("/{id}") // untuk mengedit data sesuai id
    public CommonResponse<Kelas> editKelasById(@PathVariable("id") Long id, @RequestBody KelasDto kelasDto) {
        return ResponseHelper.ok(kelasService.editKelas(id, kelasDto));
    }

    @DeleteMapping("/{id}") // untuk menghapus data sesuai id
    public CommonResponse <?> deleteKelasById(@PathVariable("id") Long id) {
        return ResponseHelper.ok(kelasService.deleteKelasById(id));}

    @GetMapping
    public CommonResponse<List<Kelas>> getAll(@RequestParam(name = "query", required = false) String query, Long UserId) {
        return ResponseHelper.ok(kelasService.getAllKelas(query == null ? "" : query, UserId));
    }

}
