package com.ph32395.khopro.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ph32395.khopro.Adapter.HoaDon_Adapter;
import com.ph32395.khopro.Adapter.MonAn_Adapter;
import com.ph32395.khopro.DAO.HoaDonDAO;
import com.ph32395.khopro.Model.HoaDon;
import com.ph32395.khopro.Model.MonAn;
import com.ph32395.khopro.R;

import java.util.ArrayList;


public class QLHoaDonFragment extends Fragment {
    HoaDonDAO dao;
    RecyclerView rc_quanLyHoaDon;
    ArrayList<HoaDon>list;
    HoaDon_Adapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_q_l_hoa_don, container, false);
        dao = new HoaDonDAO(getContext());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        rc_quanLyHoaDon = v.findViewById(R.id.rc_quanLyHoaDon);
        rc_quanLyHoaDon.setLayoutManager(layoutManager);
        list = (ArrayList<HoaDon>) dao.getAll();
        adapter = new HoaDon_Adapter(getActivity(), list);
        rc_quanLyHoaDon.setAdapter(adapter);

        return v;
    }
}