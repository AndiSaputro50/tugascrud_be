package com.sekolah.crud.Auth.Jwt;

import com.sekolah.crud.Auth.Repository.TemporaryTokenRepository;
import com.sekolah.crud.Auth.Repository.UserRepository;
import com.sekolah.crud.Auth.User.TemporaryToken;
import com.sekolah.crud.Auth.User.User;
import com.sekolah.crud.Exception.InternalErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class JwtProvider {

    private static String secretKey = "Token";
    private static Integer expired = 900000;
    @Autowired
    private TemporaryTokenRepository temporaryTokenRepository;
    @Autowired
    private UserRepository registerRepository;

    public String generateToken(UserDetails userDetails) {
        String token = UUID.randomUUID().toString().replace("-", "");
        User user = registerRepository.findByEmail(userDetails.getUsername());
        var checkingToken = temporaryTokenRepository.findBySekolahId(user.getId());
        if (checkingToken.isPresent()) temporaryTokenRepository.deleteById(checkingToken.get().getId());
        TemporaryToken temporaryToken = new TemporaryToken();
        temporaryToken.setToken(token);
        temporaryToken.setExpiredDate(new Date(new Date().getTime() + expired));
        temporaryToken.setSekolahId(user.getId());
        temporaryTokenRepository.save(temporaryToken);
        return token;
    }

    public TemporaryToken getSubject(String token) {
        return temporaryTokenRepository.findByToken(token).orElseThrow(() -> new InternalErrorException("Token error parse"));
    }

    public boolean checkingTokenJwt(String token) {
        TemporaryToken tokenExist = temporaryTokenRepository.findByToken(token).orElse(null);
        if (tokenExist == null) {
            System.out.println("Token kosong");
            return false;
        }
        if (tokenExist.getExpiredDate().before(new Date())) {
            System.out.println("Token expired");
            return false;
        }
        return true;
    }

}
