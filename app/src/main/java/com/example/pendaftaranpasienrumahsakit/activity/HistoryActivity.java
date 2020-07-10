package com.example.pendaftaranpasienrumahsakit.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.pendaftaranpasienrumahsakit.R;
import com.example.pendaftaranpasienrumahsakit.adapter.HistoryAdapter;
import com.example.pendaftaranpasienrumahsakit.database.AppDatabase;
import com.example.pendaftaranpasienrumahsakit.entity.Pasien;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity
{
    AppDatabase appDatabase;
    RecyclerView recyclerView;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        appDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ArrayList<Pasien> arrayList = (ArrayList<Pasien>) appDatabase.pasienDao().getAll();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2, RecyclerView.VERTICAL, false);
        HistoryAdapter historyAdapter = new HistoryAdapter(getApplicationContext(), arrayList);

        recyclerView = findViewById(R.id.rvhistory);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(historyAdapter);
        recyclerView.getAdapter().notifyDataSetChanged();

    }
}
