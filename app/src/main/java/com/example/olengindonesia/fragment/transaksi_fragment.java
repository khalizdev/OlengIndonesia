package com.example.olengindonesia.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.olengindonesia.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link transaksi_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class transaksi_fragment extends Fragment {

    public transaksi_fragment() {
    }
    public static transaksi_fragment newInstance(String param1, String param2) {
        transaksi_fragment fragment = new transaksi_fragment();
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
        View view = inflater.inflate(R.layout.fragment_transaksi_fragment, container, false);
        return view;
    }
}