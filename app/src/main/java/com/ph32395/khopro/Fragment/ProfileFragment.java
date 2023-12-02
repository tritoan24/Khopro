package com.ph32395.khopro.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ph32395.khopro.DAO.NhanVienDAO;
import com.ph32395.khopro.LoginActivity;
import com.ph32395.khopro.Model.NhanVien;
import com.ph32395.khopro.R;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    TextView ed_hoTenNhanVienTT, ed_tuoiNhanVienTT, ed_gioiTinhNhanVienTT, ed_sdtNhanVienTT, tv_update;
    Button btn_doiMatKhau;
    ImageView gioiTinh;
    ImageButton img_logOut;

    NhanVien nhanVien;
    NhanVienDAO nhanVienDAO;
    Context context;
    ArrayList<NhanVien> list;

    private String mma;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ed_hoTenNhanVienTT = view.findViewById(R.id.ed_hoTenNhanVienTT);
        ed_tuoiNhanVienTT = view.findViewById(R.id.ed_tuoiNhanVienTT);
        ed_gioiTinhNhanVienTT = view.findViewById(R.id.ed_gioiTinhNhanVienTT);
        ed_sdtNhanVienTT = view.findViewById(R.id.ed_sdtNhanVienTT);
        tv_update = view.findViewById(R.id.tv_updateProfile);
        btn_doiMatKhau = view.findViewById(R.id.btn_doiMatKhau);
        img_logOut = view.findViewById(R.id.img_logOut);
        gioiTinh = view.findViewById(R.id.img_daiDien);
        mma = readMmaFromSharedPreferences();
        nhanVienDAO = new NhanVienDAO(getContext());
        nhanVien = nhanVienDAO.getID(mma);

        ed_hoTenNhanVienTT.setText(String.valueOf(nhanVien.getHoTen()));
        ed_tuoiNhanVienTT.setText(String.valueOf(nhanVien.getTuoi()));
        if ("Nam".equals(nhanVien.getGioiTinh())) {
            gioiTinh.setImageResource(R.drawable.nguoidung);
        } else {
            gioiTinh.setImageResource(R.drawable.woman);
        }

        ed_gioiTinhNhanVienTT.setText(nhanVien.getGioiTinh());
        ed_sdtNhanVienTT.setText(nhanVien.getSoDienThoai());

        btn_doiMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        img_logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });

        tv_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogUpdateProfile();
            }
        });

    }

    public void dialogUpdateProfile(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = ((Activity)getContext()).getLayoutInflater();
        View v = inflater.inflate(R.layout.update_profile,null);
        builder.setView(v);
        builder.setCancelable(false);
        AlertDialog dialog = builder.create();

        EditText ed_hoTenNhanVienTT_update = v.findViewById(R.id.ed_hoTenNhanVienTT_update);
        EditText ed_tuoiNhanVienTT_update = v.findViewById(R.id.ed_tuoiNhanVienTT_update);
        EditText ed_gioiTinhNhanVienTT_update = v.findViewById(R.id.ed_gioiTinhNhanVienTT_update);
        EditText ed_sdtNhanVienTT_update = v.findViewById(R.id.ed_sdtNhanVienTT_update);
        Button btn_updateProfile = v.findViewById(R.id.btn_update_profile);
        Button btn_cancelUpdate = v.findViewById(R.id.btn_update_profile_cancel);

        ed_hoTenNhanVienTT_update.setText(ed_hoTenNhanVienTT.getText().toString());
        ed_tuoiNhanVienTT_update.setText(ed_tuoiNhanVienTT.getText().toString());
        ed_gioiTinhNhanVienTT_update.setText(ed_gioiTinhNhanVienTT.getText().toString());
        ed_sdtNhanVienTT_update.setText(ed_sdtNhanVienTT.getText().toString());

        btn_updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenNV = ed_hoTenNhanVienTT_update.getText().toString();
                int tuoiNV = Integer.parseInt(ed_tuoiNhanVienTT_update.getText().toString());
                String gioiTinhNV = ed_gioiTinhNhanVienTT_update.getText().toString();
                String sdtNV = ed_sdtNhanVienTT_update.getText().toString();

//                nhanVienDAO = new NhanVienDAO(context);
//                NhanVien nhanVienUpdate = new NhanVien(tenNV, tuoiNV, gioiTinhNV, sdtNV);
//                nhanVienUpdate.setHoTen(tenNV);
//                nhanVienUpdate.setTuoi(Integer.valueOf(tuoiNV));
//                nhanVienUpdate.setGioiTinh(gioiTinhNV);
//                nhanVienUpdate.setSoDienThoai(sdtNV);
//                nhanVienDAO.update_nv(nhanVienUpdate);
                dialog.dismiss();
            }
        });

        btn_cancelUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        dialog.show();
    }



    private String readMmaFromSharedPreferences() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        return sharedPreferences.getString("mma", "");
    }
}