package com.sekolah.crud.Auth.Repository;

import com.sekolah.crud.Auth.User.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);

    @Query(value = "SELECT * FROM table_user  WHERE " +
            "email LIKE CONCAT('%',:query, '%')", nativeQuery = true)
    Page<User> findAll(String query, Pageable pageable);

    @Query(value = "SELECT * FROM table_user  WHERE " +
            "username LIKE CONCAT('%',:username, '%')", nativeQuery = true)
    User findByUsername(String username);

}
