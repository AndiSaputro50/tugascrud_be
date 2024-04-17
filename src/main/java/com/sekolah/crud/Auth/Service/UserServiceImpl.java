package com.sekolah.crud.Auth.Service;

import com.sekolah.crud.Auth.Jwt.JwtProvider;
import com.sekolah.crud.Auth.Repository.UserRepository;
import com.sekolah.crud.Auth.User.Login;
import com.sekolah.crud.Auth.User.User;
import com.sekolah.crud.Exception.InternalErrorException;
import com.sekolah.crud.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository repository;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;

    private String authories(String email, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (BadCredentialsException e) {
            throw new InternalErrorException("Email or Password not found");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        return jwtProvider.generateToken(userDetails);
    }

    @Override
    public User registrasi(User user) {
        String UserPassword = user.getPassword().trim();
        boolean PasswordIsNotValid = !UserPassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,20}");
        if (PasswordIsNotValid) throw new InternalErrorException("Password not valid!");
        boolean isEmail = Pattern.compile("^(.+)@(\\S+)$")
                .matcher(user.getEmail()).matches();
        if (!isEmail)throw new InternalErrorException("Email Not Valid");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUsername(user.getUsername());
        return repository.save(user);

    }

    @Override
    public Map<String, Object> login(Login login) {
        String token = authories(login.getEmail(), login.getPassword());
        User sekolah ;

//        mengecek email
        boolean isEmail = Pattern.compile("^(.+)@(\\S+)$")
                .matcher(login.getEmail()).matches();
        System.out.println("is Email " + isEmail);

//        jika true, akan menjalankan sistem if
        if(isEmail) {
            sekolah = repository.findByEmail(login.getEmail());
        } else { // jika false, else akan dijalankan, dgn login username
            sekolah = repository.findByUsername(login.getEmail());
        }

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("expired", "15 menit");
        response.put("user", sekolah);
        return response;

    }

    @Override
    public User getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Id tidak ditemukan"));
    }

    @Override
    public Map<String, Boolean> deleteSekolah(Long id) {
        try {
            repository.deleteById(id);
            Map<String, Boolean> res = new HashMap<>();
            res.put("deleted", Boolean.TRUE);
            return res;
        } catch (Exception e) {
            throw new NotFoundException("Id Not Found");
        }
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
}
