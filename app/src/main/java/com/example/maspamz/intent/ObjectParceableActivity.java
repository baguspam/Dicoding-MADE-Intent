package com.example.maspamz.intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.maspamz.intent.model.Orang;

/**
 * Created by Maspamz on 16/05/2018.
 */

public class ObjectParceableActivity extends AppCompatActivity {
    public static String EXTRA_PERSON = "extra_person";
    private TextView tvObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_parceable);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Intent Parceable");

        //Mengaktifkan menu back Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        tvObject = (TextView)findViewById(R.id.tv_object_received);
        Orang mOrang = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : "+ mOrang.getName()+", Email : "+ mOrang.getEmail()+", Age : "+ mOrang.getAge()
                + ", Location : "+ mOrang.getCity();
        tvObject.setText(text);
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
