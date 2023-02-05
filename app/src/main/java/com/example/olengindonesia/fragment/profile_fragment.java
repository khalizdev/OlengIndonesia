package com.example.olengindonesia.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.olengindonesia.R;
import com.example.olengindonesia.boarding.splaschscreen;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class profile_fragment extends Fragment {
    LinearLayout exit, syarat;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    TextView email;
    public profile_fragment() {
    }

    public static profile_fragment newInstance(String param1, String param2) {
        profile_fragment fragment = new profile_fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_profile_fragment, container, false);
       exit = view.findViewById(R.id.logout);
       syarat = view.findViewById(R.id.syaratdankondisi);
       syarat.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String url = "https://oleng.online/";
               Intent i = new Intent(Intent.ACTION_VIEW);
               i.setData(Uri.parse(url));
               startActivity(i);
           }
       });
       firebaseAuth = FirebaseAuth.getInstance();
       firebaseUser = firebaseAuth.getCurrentUser();
       email = view.findViewById(R.id.emailAddress);

       exit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                firebaseAuth.signOut();
                   Intent home = new Intent(getActivity(), splaschscreen.class);
                   startActivity(home);
                   getActivity().finish();
           }
       });

       if (firebaseUser != null)
       {
           String namaEmail;
           namaEmail = firebaseUser.getEmail();
           email.setText(namaEmail);
       }
       return view;
    }
}