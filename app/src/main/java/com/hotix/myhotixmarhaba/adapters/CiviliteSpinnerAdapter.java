package com.hotix.myhotixmarhaba.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import androidx.appcompat.widget.AppCompatTextView;

import com.hotix.myhotixmarhaba.R;
import com.hotix.myhotixmarhaba.models.Civilite;

import java.util.ArrayList;

public class CiviliteSpinnerAdapter extends BaseAdapter {

    Context context;
    ArrayList<Civilite> civilites = new ArrayList<>() ;
    LayoutInflater inflter;

    public CiviliteSpinnerAdapter(Context applicationContext, ArrayList<Civilite> civilites) {
        this.context = applicationContext;
        this.civilites = civilites;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return civilites.size();
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
        view = inflter.inflate(R.layout.spinner_civilite_row_item, null);
        AppCompatTextView names = (AppCompatTextView) view.findViewById(R.id.spinner_civilite_row_tv);
        names.setText(civilites.get(i).getName());
        return view;
    }
}
