package com.ph32395.khopro.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ph32395.khopro.R;

public class HomeFragment extends Fragment {

    TextView tv_orderMonChinh, tv_orderPho, tv_orderComRang;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        tv_orderMonChinh = v.findViewById(R.id.tv_orderMonChinh);
        tv_orderPho = v.findViewById(R.id.tv_orderPho);
        tv_orderComRang = v.findViewById(R.id.tv_orderComRang);

        tv_orderMonChinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        tv_orderPho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        tv_orderComRang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return v;
    }
}