package com.example.olengindonesia.boarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.olengindonesia.MainActivity;
import com.example.olengindonesia.R;
import com.example.olengindonesia.auth.login;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class boardingone extends AppCompatActivity {
    Button lewati, next;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    String IdUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boardingone);
        lewati = findViewById(R.id.button_next_boarding_satu);
        next = findViewById(R.id.button_lewati_boarding_satu);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null)
        {
            IdUser = firebaseUser.getUid();
            Intent home = new Intent(boardingone.this, MainActivity.class);
            startActivity(home);
            finish();
        }
        lewati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(boardingone.this, login.class);
                startActivity(home);
                finish();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home=new Intent(boardingone.this, boardingtwo.class);
                startActivity(home);
                finish();
            }
        });
    }
}