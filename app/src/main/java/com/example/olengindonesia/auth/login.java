package com.example.olengindonesia.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.olengindonesia.MainActivity;
import com.example.olengindonesia.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    Button loginButton, registrasiButton;
    TextView reset;
    TextInputEditText emailIn, PasswordIn;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        registrasiButton = findViewById(R.id.registrasi_button);
        loginButton = findViewById(R.id.login_button);
        reset = findViewById(R.id.lupa_password);
        emailIn = findViewById(R.id.login_email);
        PasswordIn = findViewById(R.id.login_password);
        firebaseAuth = FirebaseAuth.getInstance();

        registrasiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home=new Intent(login.this, registrasi.class);
                startActivity(home);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home=new Intent(login.this, resetpassword.class);
                startActivity(home);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            String email, password;
            @Override
            public void onClick(View view) {
                email = emailIn.getText().toString();
                password = PasswordIn.getText().toString();

                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()) {

                                    Toast.makeText(login.this, "Berhasil Login", Toast.LENGTH_LONG).show();
//                                    progressBar.setVisibility(View.GONE);
                                    Intent home = new Intent(login.this, MainActivity.class);
                                    startActivity(home);
                                    finish();
                                }else{

                                    Toast.makeText(login.this, "Terjadi Kesalahan, silahkan coba lagi", Toast.LENGTH_LONG).show();
//                                    progressBar.setVisibility(View.GONE);
                                }
                            }
                        });
            }
        });
    }
}