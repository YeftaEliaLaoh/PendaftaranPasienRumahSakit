package com.example.pendaftaranpasienrumahsakit.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.pendaftaranpasienrumahsakit.dao.PasienDao;
import com.example.pendaftaranpasienrumahsakit.entity.Pasien;

@Database(entities = {Pasien.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract PasienDao pasienDao();

}
