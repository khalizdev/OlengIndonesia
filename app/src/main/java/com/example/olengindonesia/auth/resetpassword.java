package com.example.olengindonesia.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.olengindonesia.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class resetpassword extends AppCompatActivity {

    TextInputEditText reset;
    Button submitreset;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_resetpassword);
        reset = findViewById(R.id.reset_email_EditText);
        submitreset = findViewById(R.id.reset_button);
        submitreset.setOnClickListener(new View.OnClickListener() {
            String email;
            @Override
            public void onClick(View view) {
                email = reset.getText().toString();
                firebaseAuth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()) {

                                    Toast.makeText(resetpassword.this, "Silahkan Cek Email Anda", Toast.LENGTH_LONG).show();
                                    Intent home=new Intent(resetpassword.this, login.class);
                                    startActivity(home);
                                    finish();
                                }else{

                                    Toast.makeText(resetpassword.this, "Terjadi Kesalahan, silahkan coba lagi", Toast.LENGTH_LONG).show();
                                    Intent home=new Intent(resetpassword.this, login.class);
                                    startActivity(home);
                                    finish();
                                }
                            }
                        });
            }
        });
    }
}