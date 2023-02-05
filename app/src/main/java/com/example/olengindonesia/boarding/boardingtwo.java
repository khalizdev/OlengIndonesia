package com.example.olengindonesia.boarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.olengindonesia.R;
import com.example.olengindonesia.auth.login;

public class boardingtwo extends AppCompatActivity {
    Button lewati;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boardingtwo);
        lewati = findViewById(R.id.button_next_boarding_dua);


        lewati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(boardingtwo.this, login.class);
                startActivity(home);
                finish();
            }
        });
    }
}