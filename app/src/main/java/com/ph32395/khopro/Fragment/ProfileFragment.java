package com.ph32395.khopro.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    TextView ed_hoTenNhanVienTT , ed_tuoiNhanVienTT , ed_gioiTinhNhanVienTT ,ed_sdtNhanVienTT;
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


    }
    private String readMmaFromSharedPreferences() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        return sharedPreferences.getString("mma", "");
    }
}