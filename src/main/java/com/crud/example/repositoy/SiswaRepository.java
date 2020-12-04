package com.crud.example.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.example.model.Siswa;

@Repository
public interface SiswaRepository extends JpaRepository<Siswa, Long> {

}
