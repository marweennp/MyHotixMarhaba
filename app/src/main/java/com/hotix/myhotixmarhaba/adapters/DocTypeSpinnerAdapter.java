package com.hotix.myhotixmarhaba.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.appcompat.widget.AppCompatTextView;

import com.hotix.myhotixmarhaba.R;
import com.hotix.myhotixmarhaba.models.Piece;

import java.util.ArrayList;

public class DocTypeSpinnerAdapter extends BaseAdapter {

    Context context;
    ArrayList<Piece> pieces;
    LayoutInflater inflter;

    public DocTypeSpinnerAdapter(Context applicationContext, ArrayList<Piece> pieces) {
        this.context = applicationContext;
        this.pieces = pieces;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return pieces.size();
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
        names.setText(pieces.get(i).getName());
        return view;
    }
}
