package com.example.maspamz.intent;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnActivity, btnActivityData, btnActivityObject, btnDialNumber, btnEmail, btnCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnActivity = (Button) findViewById(R.id.BtnActivity);
        btnActivityData = (Button) findViewById(R.id.BtnActivityData);
        btnActivityObject = (Button) findViewById(R.id.BtnActivityObject);
        btnDialNumber = (Button) findViewById(R.id.BtnDialNumber);
        btnEmail = (Button) findViewById(R.id.BtnEmail);
        btnCamera = (Button) findViewById(R.id.BtnCamera);

        btnActivity.setOnClickListener(this);
        btnActivityData.setOnClickListener(this);
        btnActivityObject.setOnClickListener(this);
        btnDialNumber.setOnClickListener(this);
        btnEmail.setOnClickListener(this);
        btnCamera.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.BtnActivity:
                Intent i1= new Intent(this, PindahActivity.class);
                startActivity(i1);
                break;

            case R.id.BtnActivityData:
                Intent i2= new Intent(this, DataActivity.class);
                i2.putExtra("EXTRA_HURUF","Kirim Data Dari Activity");
                startActivity(i2);
                break;

        }

    }
}
