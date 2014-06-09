package com.formigone.easylearntutorial.model;

import android.view.View;

public interface Card {
    int getId();
    String getTitle();
    String getThumbnail();
    String getDescription();
    int getLayout();
    void fill(View view);
}
