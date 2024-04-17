package com.sekolah.crud.controller;

import com.sekolah.crud.Auth.Response.CommonResponse;
import com.sekolah.crud.Auth.Response.ResponseHelper;
import com.sekolah.crud.Auth.Service.UserService;
import com.sekolah.crud.Auth.User.Login;
import com.sekolah.crud.Auth.User.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService registerService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public CommonResponse<User> registrasi(@RequestBody User sekolah) {
        return ResponseHelper.ok(registerService.registrasi(sekolah));
    }

    @PostMapping("/login")
    public CommonResponse<Map<String, Object>> login(@RequestBody Login login) {
        return ResponseHelper.ok(registerService.login(login));
    }

    @GetMapping("/{id}")
    public CommonResponse<User> getById(@PathVariable Long id) {
        return ResponseHelper.ok(registerService.getById(id));
    }

    @DeleteMapping("/{id}")
    public CommonResponse<Map<String, Boolean>> deleteSekolah(@PathVariable("id") Long id) {
        return ResponseHelper.ok(registerService.deleteSekolah(id));
    }
    @GetMapping("/all-user")
    public CommonResponse<List<User>> getAll() {
        return ResponseHelper.ok(registerService.getAll());
    }

}
