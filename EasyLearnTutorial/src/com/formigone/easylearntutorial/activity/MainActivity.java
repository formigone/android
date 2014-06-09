package com.formigone.easylearntutorial.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	
	TextView txt = new TextView(this);
	txt.setText("Easy Learn Tutorial");
	
	setContentView(txt);
    }
}
