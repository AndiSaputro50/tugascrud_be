package com.sekolah.crud.repository;

import com.sekolah.crud.Model.Kelas;
import com.sekolah.crud.Model.Murid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MuridRepository extends JpaRepository<Murid, Long> {

}
