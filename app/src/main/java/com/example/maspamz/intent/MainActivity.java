package com.example.maspamz.intent;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.maspamz.intent.model.Orang;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnActivity, btnActivityData, btnActivityObject, btnDialNumber, btnEmail, btnCamera;
    private int REQUEST_CODE = 100;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnActivity = (Button) findViewById(R.id.BtnActivity);
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
                i2.putExtra(DataActivity.EXTRA_NAMA,"Bagus Pambudi");
                i2.putExtra(DataActivity.EXTRA_UMUR,17);
                i2.putExtra(DataActivity.EXTRA_EMAIL,"maspamzdev@gmail.com");
                i2.putExtra(DataActivity.EXTRA_ALAMAT,"Tangerang Indonesia");
                startActivity(i2);
                break;

            case R.id.BtnActivityObject:
                Orang mOrang = new Orang();
                mOrang.setName("Bagus Pambudi");
                mOrang.setAge(17);
                mOrang.setEmail("maspamzdev@gmail.com");
                mOrang.setCity("Tangerang");
                Intent i3= new Intent(this, ObjectParceableActivity.class);
                i3.putExtra(ObjectParceableActivity.EXTRA_PERSON, mOrang);
                startActivity(i3);
                break;

            case R.id.BtnDialNumber:
                String nomorku = "0895331287796";
                Intent i4= new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+nomorku));
                startActivity(i4);
                break;

            case R.id.BtnEmail:
                String mailto = "mailto:maspamzdev@gmail.com" +
                        "?cc=" + "admin@maspamz.com" +
                        "&subject=" + Uri.encode("[Importent Message] - Order Project Gan") +
                        "&body=" + Uri.encode("Hello, maspamz\n" +
                        "saya ingin mengorder project ke Anda\n" +
                        "Bolehkah saya ingin berkenalan dengan Anda lebih lanjut ?");
                Intent i5= new Intent(Intent.ACTION_SENDTO, Uri.parse(mailto));

                //Untuk choose aplikasi email
                try{
                    startActivity(i5);
                }catch (ActivityNotFoundException e){
                    //Activity kosong
                }
                break;

            case R.id.BtnCamera:
                Intent i6= new Intent("android.media.action.IMAGE_CAPTURE");
                //Untuk choose aplikasi kamera
                try{
                    startActivity(i6);
                }catch (ActivityNotFoundException e){
                    //Activity kosong
                }
                break;

            case R.id.BtnActivityResult:
                Intent moveForResultIntent = new Intent(MainActivity.this, ResultActivity.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == ResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(ResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText("Hasil : "+selectedValue);
            }
        }
    }
}
