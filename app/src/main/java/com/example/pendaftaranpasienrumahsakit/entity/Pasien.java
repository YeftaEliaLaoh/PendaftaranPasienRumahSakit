package com.example.pendaftaranpasienrumahsakit.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pasien
{
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "nama")
    public String nama;
    @ColumnInfo(name = "alamat")
    public String alamat;
    @ColumnInfo(name = "tahun")
    public String tahun;
    @ColumnInfo(name = "jenis_kelamin")
    public String jenisKelamin;

    public Pasien( String nama, String alamat, String tahun, String jenisKelamin )
    {
        this.nama = nama;
        this.alamat = alamat;
        this.tahun = tahun;
        this.jenisKelamin = jenisKelamin;
    }

}
