package com.formigone.easylearntutorial.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.formigone.easylearntutorial.R;
import com.formigone.easylearntutorial.adapter.CardAdapter;
import com.formigone.easylearntutorial.loader.SeriesLoader;
import com.formigone.easylearntutorial.model.Card;

public class SeriesListFragment extends Fragment {
    private static final String TAG = "SeriesListFragment";

    protected List<Card> mSeriesList;
    protected CardAdapter mCardAdapter;
    protected GridView mGrid;
    
    public static final int SERIES_LOADER_ID = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	    Bundle savedInstanceState) {
	View view = inflater.inflate(R.layout.fragment_list_series, container, false);
	mGrid = (GridView) view.findViewById(R.id.gridlist);

	return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
	super.onActivityCreated(savedInstanceState);
	
	getLoaderManager().initLoader(SERIES_LOADER_ID, null, mSeriesLoader);
    }

    @Override
    public void onStart() {
	super.onStart();

	mSeriesList = new ArrayList<Card>();
	mCardAdapter = new CardAdapter(getActivity(), mSeriesList);
	mGrid.setAdapter(mCardAdapter);
    }

    public void refreshData(List<Card> cards) {
	mSeriesList = cards;
    }
    
    private LoaderManager.LoaderCallbacks<List<Card>> mSeriesLoader = new LoaderManager.LoaderCallbacks<List<Card>>() {

	@Override
	public Loader<List<Card>> onCreateLoader(int id, Bundle args) {
	    return new SeriesLoader(getActivity());
	}

	@Override
	public void onLoadFinished(Loader<List<Card>> loader, List<Card> data) {
	    // TODO: Implement swapData on adapter
	    for (Card card : data) {
		mSeriesList.add(card);
	    }
	}

	@Override
	public void onLoaderReset(Loader<List<Card>> loader) {
	}
    };
}
