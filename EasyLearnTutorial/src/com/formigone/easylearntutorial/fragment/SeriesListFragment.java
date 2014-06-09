package com.formigone.easylearntutorial.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.formigone.easylearntutorial.R;

public class SeriesListFragment extends Fragment {
    private static final String TAG = "SeriesListFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	    Bundle savedInstanceState) {
	Log.i(TAG, "onCreateView");
	return inflater.inflate(R.layout.hello, container, false);
    }
}
