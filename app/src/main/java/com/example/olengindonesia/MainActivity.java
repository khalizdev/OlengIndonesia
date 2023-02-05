package com.example.olengindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.olengindonesia.fragment.home_fragment;
import com.example.olengindonesia.fragment.profile_fragment;
import com.example.olengindonesia.fragment.transaksi_fragment;

public class MainActivity extends AppCompatActivity {
    private int selectedTabs = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LinearLayout home = findViewById(R.id.home_buttonNavigation);
        final LinearLayout transaksi = findViewById(R.id.transaksi_buttonNavigation);
        final LinearLayout setting = findViewById(R.id.setting_buttonNavigation);

        final ImageView homeImg = findViewById(R.id.homeImg_buttonNavigation);
        final ImageView transaksiImg = findViewById(R.id.transaksiImg_buttonNavigation);
        final ImageView settingImg = findViewById(R.id.settingImg_buttonNavigation);

        final TextView homeTxt = findViewById(R.id.homeTxt_buttonNavigation);
        final TextView transaksiTxt = findViewById(R.id.transaksiTxt_buttonNavigation);
        final TextView settingTxt = findViewById(R.id.settingTxt_buttonNavigation);


        getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                                .replace(R.id.flFragment, home_fragment.class, null)
                                        .commit();

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedTabs != 1)
                {
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.flFragment, home_fragment.class, null)
                            .commit();
                    transaksi.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    setting.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    transaksiImg.setImageResource(R.drawable.transaksi);
                    settingImg.setImageResource(R.drawable.user);

                    transaksiTxt.setVisibility(View.GONE);
                    settingTxt.setVisibility(View.GONE);

                    homeTxt.setVisibility(View.VISIBLE);
                    homeImg.setImageResource(R.drawable.home_selected);
                    home.setBackgroundResource(R.drawable.round_buttom);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f,1f, Animation.RELATIVE_TO_SELF,0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    home.startAnimation(scaleAnimation);
                    selectedTabs = 1;
                }

            }
        });

        transaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedTabs != 2)
                {
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.flFragment, transaksi_fragment.class, null)
                            .commit();
                    home.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    setting.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    homeImg.setImageResource(R.drawable.home);
                    settingImg.setImageResource(R.drawable.user);

                    homeTxt.setVisibility(View.GONE);
                    settingTxt.setVisibility(View.GONE);

                    transaksiTxt.setVisibility(View.VISIBLE);
                    transaksiImg.setImageResource(R.drawable.transaksi_selected);
                    transaksi.setBackgroundResource(R.drawable.round_buttom);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f,1f, Animation.RELATIVE_TO_SELF,1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    transaksi.startAnimation(scaleAnimation);
                    selectedTabs = 2;
                }

            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedTabs != 3)
                {
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.flFragment, profile_fragment.class, null)
                            .commit();

                    home.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    transaksi.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    homeImg.setImageResource(R.drawable.home);
                    transaksiImg.setImageResource(R.drawable.user);

                    homeTxt.setVisibility(View.GONE);
                    transaksiTxt.setVisibility(View.GONE);

                    settingTxt.setVisibility(View.VISIBLE);
                    settingImg.setImageResource(R.drawable.user_selected);
                    setting.setBackgroundResource(R.drawable.round_buttom);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f,1f, Animation.RELATIVE_TO_SELF,1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    setting.startAnimation(scaleAnimation);
                    selectedTabs = 3;
                }

            }
        });

    }
}