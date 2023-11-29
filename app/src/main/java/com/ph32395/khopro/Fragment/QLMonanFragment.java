package com.ph32395.khopro.Fragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ph32395.khopro.Adapter.BanAnAdapter;
import com.ph32395.khopro.Adapter.DanhMuc_Adapter;
import com.ph32395.khopro.Adapter.MonAn_Adapter;
import com.ph32395.khopro.DAO.BanAnDAO;
import com.ph32395.khopro.DAO.MonAnDAO;
import com.ph32395.khopro.Model.BanAn;
import com.ph32395.khopro.Model.DanhMucMonAn;
import com.ph32395.khopro.Model.MonAn;
import com.ph32395.khopro.R;

import java.util.ArrayList;

public class QLMonanFragment extends Fragment {
    ImageView img_add_MonAn;
    RecyclerView rc_quanLyMonAn;
    EditText ed_maMonAn, ed_tenMonAn, ed_tenDanhMuc_MonAn, ed_maGiamGia_MonAn, ed_giaMon;
    Button btn_themMonAn, btn_huyThemMonAn;
    MonAnDAO monAnDAO;
    ArrayList<MonAn> list;
    MonAn_Adapter monAnAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_q_l_monan, container, false);
        rc_quanLyMonAn = v.findViewById(R.id.rc_quanLyMonAn);
        img_add_MonAn = v.findViewById(R.id.img_add_MonAn);

        monAnDAO = new MonAnDAO(getContext());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rc_quanLyMonAn.setLayoutManager(layoutManager);

        list = (ArrayList<MonAn>) monAnDAO.getAll();
        monAnAdapter = new MonAn_Adapter(getActivity(), list);
        rc_quanLyMonAn.setAdapter(monAnAdapter);


        img_add_MonAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MonAn monAn = new MonAn();
                Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.add_monan);

//                ed_maMonAn = view.findViewById(R.id.ed_tenMonAn);
//                ed_tenMonAn = view.findViewById(R.id.ed_tenMonAn);
//                ed_tenDanhMuc_MonAn = view.findViewById(R.id.ed_tenDanhMuc_MonAn);
//                ed_maGiamGia_MonAn = view.findViewById(R.id.ed_maGiamGia_MonAn);
//                ed_giaMon = view.findViewById(R.id.ed_giaMon);
//
//                btn_themMonAn = view.findViewById(R.id.btn_themMonAn);
//                btn_huyThemMonAn = view.findViewById(R.id.btn_huyThemMonAn);

//                btn_themMonAn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (validate()>0){
//                            monAn.setId_MonAn(Integer.parseInt(ed_maMonAn.getText().toString()));
//                            monAn.setTenMonAn(ed_tenMonAn.getText().toString());
//                            monAn.setId_DanhMuc(Integer.parseInt(ed_tenDanhMuc_MonAn.getText().toString()));
//                            monAn.setId_GiamGia(Integer.valueOf(ed_maGiamGia_MonAn.getText().toString()));
//                            monAn.setGiaTien(Double.parseDouble(ed_giaMon.getText().toString()));
//                            if (monAnDAO.Insert(monAn)>0){
//                                Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
//                                list = (ArrayList<MonAn>) monAnDAO.getAll();
//                                monAnAdapter = new MonAn_Adapter(getContext(), list);
//                                rc_quanLyMonAn.setAdapter(monAnAdapter);
//                                dialog.dismiss();
//                            }else {
//                                Toast.makeText(getContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    }
//                });
//
//                btn_huyThemMonAn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        dialog.dismiss();
//                    }
//                });
              dialog.show();
           }
      });
       return v;
    }

    public  int validate(){
        int check = 1;
        if(ed_maMonAn.getText().length() == 0 || ed_tenMonAn.getText().length() == 0
                || ed_tenDanhMuc_MonAn.getText().length() == 0
                || ed_giaMon.getText().length() == 0){
            Toast.makeText(getContext(), "Không bỏ trống", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }


}