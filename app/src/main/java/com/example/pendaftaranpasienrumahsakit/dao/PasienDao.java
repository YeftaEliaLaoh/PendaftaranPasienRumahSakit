package com.example.pendaftaranpasienrumahsakit.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.pendaftaranpasienrumahsakit.entity.Pasien;

import java.util.List;

@Dao
public interface PasienDao
{
    @Query("SELECT * FROM Pasien")
    List<Pasien> getAll();

    @Query("SELECT * FROM Pasien WHERE id IN (:PasienIds)")
    List<Pasien> loadAllByIds( int[] PasienIds );

    @Query("SELECT * FROM Pasien WHERE nama LIKE :nama LIMIT 1")
    Pasien findByName( String nama );

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll( Pasien... Pasiens );

    @Delete
    void delete( Pasien Pasien );

}
