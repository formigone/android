package com.formigone.easylearntutorial;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.Volley;
import com.formigone.easylearntutorial.api.TutorialApi;

public class EasyLearnTutorialApplication extends Application {
    private TutorialApi mTutorialApi;

    public static ImageCache mImageCache;
    public static RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
	super.onCreate();
	
	int cacheSize = getCacheSize();
	mImageCache = new ImageLruCache(cacheSize);
	mRequestQueue = new Volley().newRequestQueue(this);
    }

    public TutorialApi getTutorialApi() {
	if (mTutorialApi == null) {
	    mTutorialApi = new TutorialApi();
	}

	return mTutorialApi;
    }

    public ImageLoader genImageLoader() {
	return new ImageLoader(mRequestQueue, mImageCache);
    }

    private int getCacheSize() {
	int memoryClass = getMemoryClass(this);
	int factor = 8;

	// use more memory for cache on large memory devices
	if (memoryClass > 64) {
	    factor = 4;
	}

	int cacheSize = memoryClass / factor * (1024 * 1024);

	return cacheSize;
    }

    public static int getMemoryClass(Context context) {
	ActivityManager am = (ActivityManager) context
		.getSystemService(Context.ACTIVITY_SERVICE);
	return am.getMemoryClass();
    }
}
