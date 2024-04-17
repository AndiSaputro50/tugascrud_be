package com.sekolah.crud.controller;

import com.sekolah.crud.Auth.Response.CommonResponse;
import com.sekolah.crud.Auth.Response.ResponseHelper;
import com.sekolah.crud.Model.Guru;
import com.sekolah.crud.Servicee.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guru")
public class GuruController {

    @Autowired
    GuruService guruService;

    @GetMapping("/{id}") //untuk melihat sesaui id
    public CommonResponse<Guru> getGuruById(@PathVariable("id")Long id) {
        return ResponseHelper.ok(guruService.getGuru(id)) ;
    }

    @PostMapping // untuk mengepost data
    public CommonResponse<Guru> addGuru(@RequestBody Guru guru) {
        return ResponseHelper.ok(guruService.addGuru(guru));
    }

    @PutMapping("/{id}") // untuk mengedit data sesuai id
    public CommonResponse<Guru> editGuruById(@PathVariable("id") Long id, @RequestBody Guru guru) {
        return ResponseHelper.ok(guruService.editGuru(id, guru));
    }

    @DeleteMapping("/{id}") // untuk menghapus data sesuai id
    public CommonResponse <?> deleteGuruById(@PathVariable("id") Long id) {
        return ResponseHelper.ok(guruService.deleteGuruById(id));}

    @GetMapping("/all-guru")
    public CommonResponse<List<Guru>> allGuru() {
        return ResponseHelper.ok(guruService.allGuru());
    }

}
