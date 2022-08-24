# Admobie
Admobie is a library to integrate admob ads in your app fastly

>Step 1. Add the JitPack repository to your build file

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

>Step 2. Add the dependency

```
dependencies {
	        implementation 'com.github.aarfatechnology:Admobie:1.0.0'
	}

```

>Load Banner Ads

```
 LinearLayout bannerContainer = findViewById(R.id.banner_container);
 AdmobAds.loadBanner(this, bannerId, bannerContainer);
```
>Load Interstitial Ads

```
AdmobAds.loadInterstitial(this, interstialId);

```

>Show Interstitial Ads

```
 AdmobAds.showInterstitial(MainActivity.this);

```
