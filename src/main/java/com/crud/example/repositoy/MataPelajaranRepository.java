package com.crud.example.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.example.model.MataPelajaran;

@Repository
public interface MataPelajaranRepository extends JpaRepository<MataPelajaran, Long>{

}
