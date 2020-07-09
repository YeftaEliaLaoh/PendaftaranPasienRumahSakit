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
    @ColumnInfo(name = "lama")
    public String lama;
    @ColumnInfo(name = "kamar")
    public String kamar;
    @ColumnInfo(name = "penyakit")
    public String penyakit;

    public Pasien( String nama, String alamat, String tahun, String lama, String kamar, String penyakit )
    {
        this.nama = nama;
        this.alamat = alamat;
        this.tahun = tahun;
        this.lama = lama;
        this.kamar = kamar;
        this.penyakit = penyakit;
    }

}
