package com.ph32395.khopro.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ph32395.khopro.Adapter.DanhMuc_Adapter;
import com.ph32395.khopro.DAO.DanhMucDAO;
import com.ph32395.khopro.Model.DanhMucMonAn;
import com.ph32395.khopro.R;

import java.util.ArrayList;

public class QLDanhMucFragment extends Fragment {

    RecyclerView rc_danhMuc;
    ImageView img_add_DanhMuc;
    DanhMucDAO danhMucDAO;
    ArrayList<DanhMucMonAn> list;
    DanhMuc_Adapter danhMucAdapter;

    EditText ed_maDanhMuc, ed_tenDanhMuc;

    Button btn_themDanhMuc, btn_huyThemDanhMuc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_q_l_danh_muc, container, false);
        rc_danhMuc = view.findViewById(R.id.rc_quanLyDanhMuc);
        img_add_DanhMuc = view.findViewById(R.id.img_add_DanhMuc);
        list = new ArrayList<>();
        danhMucDAO = new DanhMucDAO(getContext());

        list = danhMucDAO.getListDanhMuc();
        danhMucAdapter = new DanhMuc_Adapter(getContext(), list);
        rc_danhMuc.setAdapter(danhMucAdapter);

        img_add_DanhMuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DanhMucMonAn danhMucMonAn = new DanhMucMonAn();
                Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.add_danhmuc);

                ed_maDanhMuc = view.findViewById(R.id.ed_maDanhMuc);
                ed_tenDanhMuc = view.findViewById(R.id.ed_tenDanhMuc);
                btn_themDanhMuc = view.findViewById(R.id.btn_themDanhMuc);
                btn_huyThemDanhMuc = view.findViewById(R.id.btn_huyThemDanhMuc);

                btn_themDanhMuc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (validate()>0){
                            danhMucMonAn.setId_DanhMuc(Integer.parseInt(ed_maDanhMuc.getText().toString()));
                            danhMucMonAn.setTenDanhMuc(ed_tenDanhMuc.getText().toString());
                            if (danhMucDAO.insert(danhMucMonAn)>0){
                                Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                                list = danhMucDAO.getListDanhMuc();
                                danhMucAdapter = new DanhMuc_Adapter(getContext(), list);
                                rc_danhMuc.setAdapter(danhMucAdapter);
                                dialog.dismiss();
                            }else {
                                Toast.makeText(getContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });


                dialog.show();
            }
        });

        return view;
    }

    public  int validate(){
        int check = 1;
        if(ed_maDanhMuc.getText().length() == 0 || ed_tenDanhMuc.getText().length() == 0){
            Toast.makeText(getContext(), "Không bỏ trống", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }
}