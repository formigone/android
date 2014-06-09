package com.formigone.easylearntutorial.model;

import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class Tutorial implements Card {
    protected int id;
    protected int layout;
    protected String videoId;
    protected String title;
    protected String thumbnail;
    protected String description;

    // TODO: How to handle dates in Java
    protected String date;
    protected ImageLoader mImageLoader;

    public static class Handler {
	public TextView title;
	public NetworkImageView img;
	public TextView description;
    }

    public Tutorial(int id, String title, int layout) {
	this.id = id;
	this.title = title;
	this.layout = layout;
    }

    public Tutorial(int id, String videoId, String title, int layout,
	    String thumbnail, String description, String date) {
	this.id = id;
	this.videoId = videoId;
	this.title = title;
	this.layout = layout;
	this.thumbnail = thumbnail;
	this.description = description;
	this.date = date;
    }

    public int getId() {
	return id;
    }

    public int getLayout() {
	return layout;
    }

    public void setLayout(int layout) {
	this.layout = layout;
    }

    public String getVideoId() {
	return videoId;
    }

    public void setVideoId(String videoId) {
	this.videoId = videoId;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
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

    public String getDate() {
	return date;
    }

    public void setDate(String date) {
	this.date = date;
    }

    protected Handler getHandler(View view) {
	Handler handler = (Handler) view.getTag();

	if (handler != null) {
	    return handler;
	}

	handler = new Handler();
	// handler.title = (TextView) view.findViewById(R.id.title);
	// handler.img = (NetworkImageView) view.findViewById(R.id.img);
	// handler.description = (TextView) view.findViewById(R.id.description);

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
}
