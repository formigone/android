package com.formigone.easylearntutorial.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.formigone.easylearntutorial.EasyLearnTutorialApplication;
import com.formigone.easylearntutorial.R;

public class Series implements Card {
    private static final String TAG = "Series";

    protected int id;
    protected int layout;
    protected String title;
    protected String thumbnail;
    protected String description;
    protected List<Tutorial> tutorials;
    protected ImageLoader mImageLoader;

    public static class Handler {
	public TextView title;
	public NetworkImageView img;
	public TextView description;
    }

    public Series(Context context, int id, String title, int layout) {
	this(context, id, title, layout, null);
    }

    public Series(Context context, int id, String title, int layout, List<Tutorial> tutorials) {
	this.id = id;
	this.title = title;
	this.layout = layout;
	this.tutorials = tutorials;
	
	mImageLoader = ((EasyLearnTutorialApplication)context.getApplicationContext()).genImageLoader();
    }

    public int getId() {
	return id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public int getLayout() {
	return layout;
    }

    public void setLayout(int layout) {
	this.layout = layout;
    }

    public String getThumbnail() {
	return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
	this.thumbnail = thumbnail;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public List<Tutorial> getTutorials() {
	return tutorials;
    }

    public void setTutorials(List<Tutorial> tutorials) {
	this.tutorials = tutorials;
    }

    protected Handler getHandler(View view) {
	Handler handler = (Handler) view.getTag();

	if (handler != null) {
	    return handler;
	}

	handler = new Handler();
	handler.title = (TextView) view.findViewById(R.id.title);
	handler.img = (NetworkImageView) view.findViewById(R.id.img);
	handler.description = (TextView) view.findViewById(R.id.description);

	view.setTag(handler);

	return handler;
    }

    @Override
    public void fill(View view) {
	Handler handler = getHandler(view);

	handler.title.setText(title);
	handler.description.setText(description);
	handler.img.setImageUrl(thumbnail, mImageLoader);
    }

    public static List<Card> parseJson(Context context, String rawJson) throws JSONException {
	List<Card> data = new ArrayList<Card>();

	JSONObject json = new JSONObject(rawJson);

	if (json.has("data") == false) {
	    throw new JSONException("missing data array");
	}

	JSONArray res = json.getJSONArray("data");

	for (int i = 0; i < res.length(); i++) {
	    JSONObject obj = res.getJSONObject(i);
	    Series series = new Series(context, (i + 1), "Series " + obj.getString("title"),
		    R.layout.view_card_series);
	    series.setThumbnail(obj.getString("img"));
	    data.add(series);
	}

	return data;
    }
}
