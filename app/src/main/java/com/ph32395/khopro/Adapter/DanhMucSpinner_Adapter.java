package com.ph32395.khopro.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ph32395.khopro.Model.DanhMucMonAn;
import com.ph32395.khopro.R;

import java.util.ArrayList;

public class DanhMucSpinner_Adapter extends ArrayAdapter<DanhMucMonAn> {
    private Context context;
    private ArrayList<DanhMucMonAn> list;
    TextView tvTenDM;

    public DanhMucSpinner_Adapter(@NonNull Context context, ArrayList<DanhMucMonAn> list) {
        super(context, 0,list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null){
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_spinner_danhmuc,null);

        }
        final DanhMucMonAn item = list.get(position);
        if (item != null){
            tvTenDM = v.findViewById(R.id.tv_tenDanhMuc_spinner);
            tvTenDM.setText(item.getTenDanhMuc());
        }

        return v;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null){
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_spinner_danhmuc,null);

        }
        final DanhMucMonAn item = list.get(position);
        if (item != null){
            tvTenDM = v.findViewById(R.id.tv_tenDanhMuc_spinner);
            tvTenDM.setText(item.getTenDanhMuc());
        }

        return v;
    }
}
