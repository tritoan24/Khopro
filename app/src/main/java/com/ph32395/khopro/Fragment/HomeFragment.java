package com.ph32395.khopro.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ph32395.khopro.Adapter.DanhMuc_Adapter;
import com.ph32395.khopro.Adapter.HomeOderAdapter;
import com.ph32395.khopro.Adapter.MonAnOrder_Adapter;
import com.ph32395.khopro.DAO.DanhMucDAO;
import com.ph32395.khopro.DAO.MonAnDAO;
import com.ph32395.khopro.Model.DanhMucMonAn;
import com.ph32395.khopro.Model.MonAn;
import com.ph32395.khopro.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    RecyclerView dm;
    DanhMucDAO danhMucDAO;
    ArrayList<DanhMucMonAn> list;
    HomeOderAdapter danhMucAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        dm = v.findViewById(R.id.rc_danhmucorder);
        danhMucDAO = new DanhMucDAO(getContext());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        dm.setLayoutManager(layoutManager);

        list = (ArrayList<DanhMucMonAn>) danhMucDAO.getAll();
        danhMucAdapter = new HomeOderAdapter(getActivity(), this, list);
        dm.setAdapter(danhMucAdapter);

        Bundle arguments = getArguments();
        if (arguments != null) {
            // Lấy số bàn từ Bundle
            int soBan = arguments.getInt("SoBan", 0);

            // Bây giờ bạn có thể sử dụng giá trị soBan như mong muốn
            // Ví dụ: hiển thị số bàn trong Log
            Toast.makeText(getContext(), "Số Bàn là: "+soBan, Toast.LENGTH_SHORT).show();
        }
        return v;
    }


}