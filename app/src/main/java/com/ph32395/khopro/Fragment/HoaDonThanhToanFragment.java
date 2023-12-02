package com.ph32395.khopro.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.ph32395.khopro.R;


public class HoaDonThanhToanFragment extends Fragment {
    TextView tv_maHoaDon_hoaDon,tv_soBan_hoaDon, tv_gioTao_hoaDon,tv_maNhanVien_hoaDon, tv_ngayTao_hoaDon, tv_thanhTien_hoaDon, tv_giamGia_hoaDon, tv_truTien_hoaDon, tv_tongTien_hoaDon;

    ListView lv_hoaDon_ThanhToan;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hoa_don_thanh_toan, container, false);
        tv_maHoaDon_hoaDon = v.findViewById(R.id.tv_maHoaDon_hoaDon);
        tv_soBan_hoaDon = v.findViewById(R.id.tv_soBan_hoaDon);
        tv_gioTao_hoaDon = v.findViewById(R.id.tv_gioTao_hoaDon);
        tv_maNhanVien_hoaDon = v.findViewById(R.id.tv_maNhanVien_hoaDon);
        tv_ngayTao_hoaDon = v.findViewById(R.id.tv_ngayTao_hoaDon);
        tv_thanhTien_hoaDon = v.findViewById(R.id.tv_thanhTien_hoaDon);
        tv_giamGia_hoaDon = v.findViewById(R.id.tv_giamGia_hoaDon);
        tv_truTien_hoaDon = v.findViewById(R.id.tv_truTien_hoaDon);
        tv_tongTien_hoaDon = v.findViewById(R.id.tv_tongTien_hoaDon);

        lv_hoaDon_ThanhToan = v.findViewById(R.id.lv_hoaDon_ThanhToan);

        return v;
    }
}