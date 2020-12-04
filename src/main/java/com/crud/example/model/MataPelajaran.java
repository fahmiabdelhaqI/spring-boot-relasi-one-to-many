package com.crud.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "matapelajaran")
public class MataPelajaran {
	
	@Id
	private long idMataPelajaran;
	private String namaPelajaran;
	private long idSiswa;
	private int nilai;
	
	@Override
	public String toString() {
		return "matapelajaran [idMataPelajaran=" + idMataPelajaran +", namaPelajaran=" + namaPelajaran + ",idSiswa=" + idSiswa +", nilai=" + nilai +"]";
	}

}
