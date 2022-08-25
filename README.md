# Admobie
Admobie is a library to integrate admob ads in your app fastly

### Step 1. Add the JitPack repository to your build file

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

### Step 2. Add the dependency

```
dependencies {
	        implementation 'com.github.aarfatechnology:Admobie:1.0.0'
	}

```

### Step 3. Add In Manifest file
```
<manifest>
    <application>
       ...
        <meta-data
            android:name="com.google.android.gms.ads.APPLICATION_ID"
            android:value="ca-app-pub-3940256099942544~3347511713"/>
	...
    </application>
</manifest>
```

### Load Banner Ads

>Use this code in Layout file
```
<LinearLayout
        android:id="@+id/banner_container"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_centerHorizontal="true"
        android:layout_alignParentBottom="true"/>
```

>Use this in your activity/fragment 
```
 LinearLayout bannerContainer = findViewById(R.id.banner_container);
 AdmobAds.loadBanner(this, bannerId, bannerContainer);
```

### Load Interstitial Ads
```
AdmobAds.loadInterstitial(this, interstialId);

```

### Show Interstitial Ads
```
 AdmobAds.showInterstitial(MainActivity.this);

```
