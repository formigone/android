package com.formigone.easylearntutorial.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.formigone.easylearntutorial.R;
import com.formigone.easylearntutorial.fragment.SeriesListFragment;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    
    protected int mFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	setContentView(R.layout.activity_fullscreen_frame);
	mFrame = R.id.main_frame;

	Fragment frag = new SeriesListFragment();
	getFragmentManager().beginTransaction().add(mFrame, frag).commit();

	Log.i(TAG, "onCreate");
    }
}
