package com.sekolah.crud.Auth.Service;

import com.sekolah.crud.Auth.User.Login;
import com.sekolah.crud.Auth.User.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface UserService {

    User registrasi(User user);

    Map<String, Object> login(Login login);

    User getById(Long id);

    Map<String, Boolean> deleteSekolah(Long id);

    List<User> getAll();

}
