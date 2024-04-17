package com.sekolah.crud.controller;

import com.sekolah.crud.Auth.Response.CommonResponse;
import com.sekolah.crud.Auth.Response.ResponseHelper;
import com.sekolah.crud.Dto.MapelDto;
import com.sekolah.crud.Model.Mapel;
import com.sekolah.crud.Servicee.MapelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mapel")
public class MapelController {

    @Autowired
    MapelService mapelService;

    @GetMapping("/{id}") //untuk melihat sesaui id
    public CommonResponse<Mapel> getMapelById(@PathVariable("id")Long id) {
        return ResponseHelper.ok(mapelService.getMapel(id)) ;
    }

    @PostMapping // untuk mengepost data
    public CommonResponse<Mapel> addMapel(@RequestBody MapelDto mapel) {
        return ResponseHelper.ok(mapelService.addMapel(mapel));
    }

    @PutMapping("/{id}") // untuk mengedit data sesuai id
    public CommonResponse<Mapel> editMapelById(@PathVariable("id") Long id, @RequestBody MapelDto mapel) {
        return ResponseHelper.ok(mapelService.editMapel(id, mapel));
    }

    @DeleteMapping("/{id}") // untuk menghapus data sesuai id
    public CommonResponse <?> deleteMapelById(@PathVariable("id") Long id) {
        return ResponseHelper.ok(mapelService.deleteMapelById(id));}

    @GetMapping("/all-guru")
    public CommonResponse<List<Mapel>> allMapel() {
        return ResponseHelper.ok(mapelService.allMapel());
    }
}
