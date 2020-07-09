package com.example.pendaftaranpasienrumahsakit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

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
    TextView tvHasil;


    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NamaPasien = (EditText) findViewById(R.id.NamaPasien);
        AlamatPasien = (EditText) findViewById(R.id.AlamatPasien);
        TahunPasien = (EditText) findViewById(R.id.TahunPasien);
        LamaMenginapPasien = (EditText) findViewById(R.id.LamaMenginapPasien);

        radioButtonLaki = (RadioButton) findViewById(R.id.radioButtonLaki);
        radioButtonPerempuan = (RadioButton) findViewById(R.id.radioButtonPerempuan);

        checkBoxAnggrek = (CheckBox) findViewById(R.id.checkBoxAnggrek);
        checkBoxMawar = (CheckBox) findViewById(R.id.checkBoxMawar);
        checkBoxMelati = (CheckBox) findViewById(R.id.checkBoxMelati);

        spinnerPenyakit = (Spinner) findViewById(R.id.spinnerPenyakit);
        buttonOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.tvHasil);


        buttonOK.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                doProces();
            }
        });
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

        tvHasil.setText("Nama : " + nama + "\n" +
                "Alamat : " + alamat + "\n" +
                "Tahun : " + tahun + "\n" +
                "Lama Menginap : " + lamamenginap + "\n" +
                "Jenis Kelamin : " + jeniskelamin + "\n" +
                "Nama Kamar : " + namakamar + "\n" +
                "Jenis Penyakit : " + jenispenyakit + "\n"
        );


    }

}


