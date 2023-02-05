package com.example.olengindonesia.boarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.olengindonesia.R;

public class splaschscreen extends AppCompatActivity {
    private int waktu_loading =4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splaschscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent home=new Intent(splaschscreen.this, boardingone.class);
                startActivity(home);
                finish();
            }
        },waktu_loading);
    }
}