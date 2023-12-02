package com.ph32395.khopro.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ph32395.khopro.R;

public class ThanhToanFragment extends Fragment {

    Button btn_thanhToanTienMat , btn_thanhToanChuyenKhoan , btn_thanhToanTheNganHang,btn_quayLaiMonAn , btn_tiepTuc;
    TextView tv_maGiamGiaThanhToan , tv_ghiChu;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_thanhtoan, container, false);

        btn_thanhToanTienMat = v.findViewById(R.id.btn_thanhToanTienMat);
        btn_thanhToanChuyenKhoan = v.findViewById(R.id.btn_thanhToanChuyenKhoan);
        btn_thanhToanTheNganHang = v.findViewById(R.id.btn_thanhToanTheNganHang);
        btn_quayLaiMonAn = v.findViewById(R.id.btn_quayLaiMonAn);
        btn_tiepTuc = v.findViewById(R.id.btn_tiepTuc);
        tv_maGiamGiaThanhToan = v.findViewById(R.id.tv_maGiamGiaThanhToan);
        tv_ghiChu = v.findViewById(R.id.tv_giChu);
        return v;
    }
}
