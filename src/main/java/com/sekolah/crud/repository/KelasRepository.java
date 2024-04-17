package com.sekolah.crud.repository;

import com.sekolah.crud.Model.Kelas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KelasRepository extends JpaRepository<Kelas, Long> {

    @Query(value = "SELECT * FROM table_kelas  WHERE nama_kelas LIKE CONCAT('%', ?1, '%')",nativeQuery = true)
    List<Kelas> searchfindAll(String search , Long UserId);

}
