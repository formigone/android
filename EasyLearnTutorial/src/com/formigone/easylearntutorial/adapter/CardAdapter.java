package com.formigone.easylearntutorial.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.formigone.easylearntutorial.model.Card;

public class CardAdapter extends BaseAdapter {
    protected List<Card> mCards;
    protected Context mContext;

    public CardAdapter(Context context, List<Card> cards) {
	super();
	mContext = context;
	mCards = cards;
    }

    @Override
    public int getCount() {
	return mCards.size();
    }

    @Override
    public Object getItem(int position) {
	return mCards.get(position);
    }

    @Override
    public long getItemId(int position) {
	return mCards.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
	Card card = (Card) getItem(position);

	if (convertView == null) {
	    LayoutInflater inflater = LayoutInflater.from(mContext);
	    convertView = inflater.inflate(card.getLayout(), null);
	}

	card.fill(convertView);
	return convertView;
    }
}
