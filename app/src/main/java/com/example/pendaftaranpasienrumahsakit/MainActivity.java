package com.example.pendaftaranpasienrumahsakit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.pendaftaranpasienrumahsakit.database.AppDatabase;
import com.example.pendaftaranpasienrumahsakit.entity.Pasien;

public class MainActivity extends AppCompatActivity
{
    EditText NamaPasien;
    EditText AlamatPasien;
    EditText TahunPasien;
    EditText LamaMenginapPasien;
    RadioButton radioButtonLaki, radioButtonPerempuan;
    CheckBox checkBoxAnggrek, checkBoxMawar, checkBoxMelati;
    Spinner spinnerPenyakit;
    Button buttonOK;
    LinearLayout layoutNavigation;
    ImageView imgBtnShowNavigation;

    AppDatabase appDatabase;

    private boolean navigationIsShowing = true;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NamaPasien = findViewById(R.id.NamaPasien);
        AlamatPasien = findViewById(R.id.AlamatPasien);
        TahunPasien = findViewById(R.id.TahunPasien);
        LamaMenginapPasien = findViewById(R.id.LamaMenginapPasien);

        radioButtonLaki = findViewById(R.id.radioButtonLaki);
        radioButtonPerempuan = findViewById(R.id.radioButtonPerempuan);

        checkBoxAnggrek = findViewById(R.id.checkBoxAnggrek);
        checkBoxMawar = findViewById(R.id.checkBoxMawar);
        checkBoxMelati = findViewById(R.id.checkBoxMelati);

        spinnerPenyakit = findViewById(R.id.spinnerPenyakit);
        buttonOK = findViewById(R.id.buttonOK);

        buttonOK.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                doProces();
            }
        });
        layoutNavigation = findViewById(R.id.layout_navigation);
        imgBtnShowNavigation = findViewById(R.id.imgbtn_navigation);

        imgBtnShowNavigation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                Utility.hideKeyboard(v);
                showOrHideNavigation(layoutNavigation);
            }
        });

        appDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();

    }

    private void showOrHideNavigation( LinearLayout layoutNavigation )
    {
        if( navigationIsShowing )
        {
            navigationIsShowing = false;
            layoutNavigation.setVisibility(View.VISIBLE);

        }
        else
        {
            navigationIsShowing = true;
            layoutNavigation.setVisibility(View.GONE);
        }
    }

    private void doProces()
    {
        String nama = NamaPasien.getText().toString();
        String alamat = AlamatPasien.getText().toString();
        String tahun = TahunPasien.getText().toString();
        String lamamenginap = LamaMenginapPasien.getText().toString();
        String jeniskelamin = "";
        String namakamar = "";
        String jenispenyakit = spinnerPenyakit.getSelectedItem().toString();

        if( radioButtonLaki.isChecked() )
        {
            jeniskelamin = radioButtonLaki.getText().toString();
        }
        else if( radioButtonPerempuan.isChecked() )
        {
            jeniskelamin = radioButtonPerempuan.getText().toString();
        }

        if( checkBoxAnggrek.isChecked() )
            namakamar += checkBoxAnggrek.getText().toString();
        if( checkBoxMelati.isChecked() )
            namakamar += checkBoxMelati.getText().toString();
        if( checkBoxMawar.isChecked() )
            namakamar += checkBoxMawar.getText().toString();

        Pasien pasien = new Pasien(nama, alamat, tahun, lamamenginap, jeniskelamin, namakamar, jenispenyakit);
        appDatabase.pasienDao().insertAll(pasien);
    }

}


