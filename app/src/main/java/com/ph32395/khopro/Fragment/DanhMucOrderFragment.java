package com.ph32395.khopro.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ph32395.khopro.Adapter.HomeOderAdapter;
import com.ph32395.khopro.DAO.DanhMucDAO;
import com.ph32395.khopro.Model.DanhMucMonAn;
import com.ph32395.khopro.R;

import java.util.ArrayList;


public class DanhMucOrderFragment extends Fragment {
    RecyclerView dm;
    DanhMucDAO danhMucDAO;
    ArrayList<DanhMucMonAn> list;
    HomeOderAdapter danhMucAdapter;
    Button back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        dm = v.findViewById(R.id.rc_danhmucorder);
        danhMucDAO = new DanhMucDAO(getContext());
        back=v.findViewById(R.id.btnbackdm);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        dm.setLayoutManager(layoutManager);

        list = (ArrayList<DanhMucMonAn>) danhMucDAO.getAll();
        danhMucAdapter = new HomeOderAdapter(getActivity(), this, list);
        dm.setAdapter(danhMucAdapter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                BanAnOrderFragment anotherFragment = new BanAnOrderFragment();

                fragmentTransaction.replace(R.id.flContent, anotherFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        return v;
    }


}