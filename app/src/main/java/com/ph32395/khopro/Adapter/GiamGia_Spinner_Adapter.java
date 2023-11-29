package com.ph32395.khopro.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ph32395.khopro.Model.GiamGia;
import com.ph32395.khopro.R;

import java.util.ArrayList;

public class GiamGia_Spinner_Adapter extends ArrayAdapter<GiamGia> {
    private Context context;
    private ArrayList<GiamGia>list;
    TextView txtMaGiamGia, txtPhanTramGG;
    public GiamGia_Spinner_Adapter(@NonNull Context context, ArrayList<GiamGia>list) {
        super(context, 0,list);
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_spinner_giamgia, null);

        }
        final GiamGia item = list.get(position);
        if (item != null){
            txtMaGiamGia = v.findViewById(R.id.txt_maGiamGia_spinner);
            txtPhanTramGG = v.findViewById(R.id.txt_phanTramGG_spinner);
            txtMaGiamGia.setText(item.getMaGiamGia());
            txtPhanTramGG.setText(item.getPhanTramGiam()+"%");
        }


        return v;
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_spinner_giamgia, null);

        }
        final GiamGia item = list.get(position);
        if (item != null) {
            txtMaGiamGia = v.findViewById(R.id.txt_maGiamGia_spinner);
            txtPhanTramGG = v.findViewById(R.id.txt_phanTramGG_spinner);
            txtMaGiamGia.setText(item.getMaGiamGia());
            txtPhanTramGG.setText(item.getPhanTramGiam()+"%");
        }

        return v;
    }
}

