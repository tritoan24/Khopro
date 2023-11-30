package com.ph32395.khopro.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.ph32395.khopro.DAO.DanhMucDAO;
import com.ph32395.khopro.DAO.MonAnDAO;
import com.ph32395.khopro.Model.DanhMucMonAn;
import com.ph32395.khopro.Model.MonAn;
import com.ph32395.khopro.R;

import java.util.List;


public class HomeFragment extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);


    return view;
    }


}