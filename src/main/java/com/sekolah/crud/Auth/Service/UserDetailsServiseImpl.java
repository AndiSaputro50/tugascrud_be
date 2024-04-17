package com.sekolah.crud.Auth.Service;

import com.sekolah.crud.Auth.Repository.UserRepository;
import com.sekolah.crud.Auth.User.User;
import com.sekolah.crud.Auth.User.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserDetailsServiseImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        mengecek email
        boolean isEmail = Pattern.compile("^(.+)@(\\S+)$")
                .matcher(username).matches();
        User user;
        System.out.println("is Email " + isEmail);

//        jika email ada
        if(isEmail) {
            user = userRepository.findByEmail(username);
        } else { // else username
            user = userRepository.findByUsername(username);
        }
        return UserPrinciple.build(user);

    }
}
