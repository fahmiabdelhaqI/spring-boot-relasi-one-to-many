package com.crud.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "siswas")
public class Siswa {

	@Id
	private long idSiswa;
	private String nama_depan;
	private String nama_belakang;
	private String hobi;
	private String alamat;
	
	@Override
	public String toString() {
		return "Siswa [ idSiswa=" + idSiswa + ", nama_depan=" + nama_depan + ", "
				+ "nama_belakang=" + nama_belakang + ", hobi=" + hobi + ", alamat=" + alamat + " ]";
	}
}
