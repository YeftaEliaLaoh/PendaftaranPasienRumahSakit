package com.example.pendaftaranpasienrumahsakit.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pendaftaranpasienrumahsakit.MainFragment;
import com.example.pendaftaranpasienrumahsakit.R;

public class ReportActivity extends AppCompatActivity
{


    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        if( savedInstanceState == null )
        {
            getSupportFragmentManager().beginTransaction().add(R.id.activity_container, new
                    MainFragment(getApplicationContext()), MainFragment.class.getSimpleName()).commit();
        }

    }
}
