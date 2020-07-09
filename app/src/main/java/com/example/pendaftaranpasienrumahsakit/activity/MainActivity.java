package com.example.pendaftaranpasienrumahsakit.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.pendaftaranpasienrumahsakit.R;
import com.example.pendaftaranpasienrumahsakit.Utility;
import com.example.pendaftaranpasienrumahsakit.database.AppDatabase;
import com.example.pendaftaranpasienrumahsakit.entity.Pasien;
import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

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
    ImageView imageViewLocate;
    ImageView imageViewHistory;
    ImageView imageViewLogout;

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

        imageViewLocate = this.findViewById(R.id.ic_page_locate);

        imageViewLocate.setOnClickListener(new View.OnClickListener()
        {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);

            @Override
            public void onClick( View v )
            {
                if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN )
                {
                    startActivity(intent, null);
                }
            }
        });

        imageViewHistory = this.findViewById(R.id.ic_page_history);
        imageViewHistory.setOnClickListener(new View.OnClickListener()
        {
            Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);

            @Override
            public void onClick( View v )
            {
                if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN )
                {
                    startActivity(intent, null);
                }
            }
        });

        imageViewLogout = this.findViewById(R.id.ic_page_logout);
        imageViewLogout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                finish();
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

        try
        {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap("content", BarcodeFormat.QR_CODE, 400, 400);
            ImageView imageViewQrCode = findViewById(R.id.imageView);
            imageViewQrCode.setImageBitmap(bitmap);
        }
        catch ( Exception exception )
        {

        }


    }
}


