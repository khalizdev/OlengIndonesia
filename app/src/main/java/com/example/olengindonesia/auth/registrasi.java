package com.example.olengindonesia.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.olengindonesia.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registrasi extends AppCompatActivity {
    TextInputEditText email_regis;
    TextInputEditText password_regis;
    TextInputEditText konfirmasi_regis;
    TextInputEditText nama_regis;
    FirebaseAuth firebaseAuth;
    Button daftarRegistrasi;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        progressBar = findViewById(R.id.ProgressBar_Registrasi);
        firebaseAuth = FirebaseAuth.getInstance();
        email_regis = findViewById(R.id.regist_email_EditText);
        password_regis = findViewById(R.id.regist_password_EditText);
        konfirmasi_regis = findViewById(R.id.regist_konfirmasi_password_EditText);
        nama_regis = findViewById(R.id.regist_NamaPanggilan_EditText);
        daftarRegistrasi = findViewById(R.id.daftar_button);

        progressBar.setVisibility(View.GONE);

        daftarRegistrasi.setOnClickListener(new View.OnClickListener() {
            String email, password, nama;
            @Override
            public void onClick(View view) {
//                progressBar.setVisibility(View.VISIBLE);
                email = email_regis.getText().toString();
                password = konfirmasi_regis.getText().toString();
                nama = nama_regis.getText().toString();

                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()) {

                                    Toast.makeText(registrasi.this, "Berhasil melakukan registrasi", Toast.LENGTH_LONG).show();
//                                    progressBar.setVisibility(View.GONE);
                                    Intent home = new Intent(registrasi.this, login.class);
                                    startActivity(home);
                                    finish();
                                }else{

                                    Toast.makeText(registrasi.this, "Terjadi Kesalahan, silahkan coba lagi", Toast.LENGTH_LONG).show();

                                }
                            }
                        });
            }
        });


    }
}