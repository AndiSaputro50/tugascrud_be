package com.sekolah.crud.repository;

import com.sekolah.crud.Model.Mapel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapelRepository extends JpaRepository<Mapel, Long> {

    @Query(value = "SELECT * FROM table_mapel  WHERE nama_mapel LIKE CONCAT('%', ?1, '%')",nativeQuery = true)
    List<Mapel> findAll(Long UserId);
}
