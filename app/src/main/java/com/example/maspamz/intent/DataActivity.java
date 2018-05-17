package com.example.maspamz.intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {
    public  static String EXTRA_NAMA ="extra_nama";
    public  static String EXTRA_UMUR ="extra_umur";
    public  static String EXTRA_EMAIL ="extra_email";
    public  static String EXTRA_ALAMAT ="extra_alamat";
    TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pindah);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Data Activity");

        //Mengaktifkan menu beck Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Ambil data yg dikirim
        String GetNama = getIntent().getStringExtra(EXTRA_NAMA);
        int GetUmur = getIntent().getIntExtra(EXTRA_UMUR,0);
        String GetEmail = getIntent().getStringExtra(EXTRA_EMAIL);
        String GetAlamat = getIntent().getStringExtra(EXTRA_ALAMAT);

        txtData = (TextView) findViewById(R.id.txtAmbilData);

        txtData.setText("Nama    : " + GetNama + "\n" +
                        "Umur    : " + GetUmur + "\n" +
                        "Email   : " + GetEmail + "\n" +
                        "Alamat  : " + GetAlamat + "\n"
        );



    }

    //Fungsi back button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
