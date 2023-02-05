package com.example.olengindonesia.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.olengindonesia.MainActivity;
import com.example.olengindonesia.R;
import com.example.olengindonesia.auth.login;
import com.example.olengindonesia.boarding.boardingone;
import com.example.olengindonesia.searchtalent;

import java.util.ArrayList;

public class home_fragment extends Fragment {

    ImageSlider imageSlider;
    LinearLayout ngopii, shoppingg, travellingg, allinn;
//    ImageView back;

    public home_fragment() {
    }
    public static home_fragment newInstance(String param1, String param2) {
        home_fragment fragment = new home_fragment();
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
        View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);
        imageSlider = view.findViewById(R.id.imageSlider);
        ngopii = view.findViewById(R.id.ngopi);
        shoppingg = view.findViewById(R.id.shopping);
        travellingg = view.findViewById(R.id.travelling);
        allinn = view.findViewById(R.id.allJenis);
//        back = view.findViewById(R.id.backButton);

//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent home = new Intent(getActivity(), MainActivity.class);
//                startActivity(home);
//                getActivity().finish();
//            }
//        });


        ngopii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(getActivity(), searchtalent.class);
                startActivity(home);
            }
        });

        travellingg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(getActivity(), searchtalent.class);
                startActivity(home);
            }
        });

        shoppingg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(getActivity(), searchtalent.class);
                startActivity(home);
            }
        });


        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/oleng-5a0d7.appspot.com/o/banner%2F5146211.jpg?alt=media&token=4b2e4eea-d352-41a9-9042-9fbf3bbdb570", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/oleng-5a0d7.appspot.com/o/banner%2FSummer_Sale_Background_4.jpg?alt=media&token=dcbb8ac8-0f72-4cfc-bace-88fb07a23412", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/oleng-5a0d7.appspot.com/o/banner%2Fsale_rorozoanew_05.jpg?alt=media&token=4c77d2c7-af22-45df-ab1a-4a5593aa203d", ScaleTypes.FIT));


        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        return view;
    }
}