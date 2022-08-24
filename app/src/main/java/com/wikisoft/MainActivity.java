package com.wikisoft;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wikisoft.admobads.AdmobAds;

public class MainActivity extends AppCompatActivity {
    public static String bannerId = "ca-app-pub-3940256099942544/6300978111";
    public static String interstialId = "ca-app-pub-3940256099942544/1033173712";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdmobAds.loadBanner(this, bannerId, findViewById(R.id.banner_container));
        AdmobAds.loadInterstitial(this, interstialId);

        findViewById(R.id.btn_interstitial_ad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdmobAds.showInterstitial(MainActivity.this);
            }
        });

    }
}