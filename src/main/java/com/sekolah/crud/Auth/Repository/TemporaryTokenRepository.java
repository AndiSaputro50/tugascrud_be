package com.sekolah.crud.Auth.Repository;

import com.sekolah.crud.Auth.User.TemporaryToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TemporaryTokenRepository extends JpaRepository<TemporaryToken, Long> {

    Optional<TemporaryToken> findByToken(String token);
    Optional<TemporaryToken> findBySekolahId(long sekolahId);

}
