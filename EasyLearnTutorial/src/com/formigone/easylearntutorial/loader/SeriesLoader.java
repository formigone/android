package com.formigone.easylearntutorial.loader;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.formigone.easylearntutorial.EasyLearnTutorialApplication;
import com.formigone.easylearntutorial.R;
import com.formigone.easylearntutorial.api.TutorialApi;
import com.formigone.easylearntutorial.model.Card;
import com.formigone.easylearntutorial.model.Series;

public class SeriesLoader extends AsyncTaskLoader<List<Card>> {
    private static final String TAG = "SeriesLoader";

    private List<Card> mCards;

    public SeriesLoader(Context context) {
	super(context);
    }

    @Override
    public List<Card> loadInBackground() {
	TutorialApi api = ((EasyLearnTutorialApplication) getContext()
		.getApplicationContext()).getTutorialApi();
	String rawJson = api.getSeries(10).data;

	List<Card> data = new ArrayList<Card>();

	try {
	    data = Series.parseJson(getContext(), rawJson);
	} catch (JSONException e) {
	    e.printStackTrace();
	}

	return data;
    }

    @Override
    public void onCanceled(List<Card> data) {
	super.onCanceled(data);
    }

    @Override
    protected void onStartLoading() {
	if (mCards != null) {
	    deliverResult(mCards);
	}

	if (takeContentChanged() || mCards == null) {
	    forceLoad();
	}
    }

    @Override
    protected void onStopLoading() {
	super.onStopLoading();
    }

    @Override
    public void deliverResult(List<Card> data) {
	mCards = data;

	if (isStarted()) {
	    super.deliverResult(mCards);
	}
    }
}
