package com.wikisoft.admobads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class AdmobAds {

    public static String interstialID = "";

    public static InterstitialAd mInterstitialAd;

    public static void loadBanner(Context context, String bannerId, LinearLayout bannerContainer){
        AdView adView = new AdView(context);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(bannerId);
        bannerContainer.addView(adView);
        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);
    }

    public static void loadInterstitial(Activity context, String InterstitialID){

        interstialID = InterstitialID;

        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(context, InterstitialID, adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                mInterstitialAd = null;

            }

            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {

                mInterstitialAd = interstitialAd;

                //Toast.makeText(context, "ad loaded", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void showInterstitial(Activity activity, Intent intent){

        if(mInterstitialAd != null){

            mInterstitialAd.show(activity);

            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {

                @Override
                public void onAdDismissedFullScreenContent() {
                    mInterstitialAd = null;
                    activity.startActivity(intent);
                    loadInterstitial(activity, interstialID);
                }

                @Override
                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                    mInterstitialAd = null;
                }

                @Override
                public void onAdShowedFullScreenContent() {
                    super.onAdShowedFullScreenContent();
                }
            });
        }else{
            activity.startActivity(intent);
        }

    }


    public static void showInterstitial(Activity activity){

        if(mInterstitialAd != null){
            mInterstitialAd.show(activity);

            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {

                @Override
                public void onAdDismissedFullScreenContent() {
                    mInterstitialAd = null;
                    loadInterstitial(activity,interstialID);
                }

                @Override
                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                    mInterstitialAd = null;
                }

                @Override
                public void onAdShowedFullScreenContent() {
                    super.onAdShowedFullScreenContent();
                }
            });
        }

    }

}
