package com.hotix.myhotixmarhaba.adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.appcompat.widget.AppCompatTextView;

import com.hotix.myhotixmarhaba.R;
import com.hotix.myhotixmarhaba.models.Pay;

import java.util.ArrayList;

public class CountrySpinnerAdapter extends BaseAdapter {

    Context context;
    ArrayList<Pay> pays;
    LayoutInflater inflter;

    public CountrySpinnerAdapter(Context applicationContext, ArrayList<Pay> pays) {
        this.context = applicationContext;
        this.pays = pays;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return pays.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.spinner_simple_row_item, null);
        AppCompatTextView names = (AppCompatTextView) view.findViewById(R.id.spinner_simple_row_tv);
        names.setText(pays.get(i).getName());
        return view;
    }
}
