package com.ph32395.khopro.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ph32395.khopro.Adapter.HoaDonChiTietAdapter;
import com.ph32395.khopro.DAO.ChiTietHoaDonDAO;
import com.ph32395.khopro.DAO.NhanVienDAO;
import com.ph32395.khopro.Model.ChiTietHoaDon;
import com.ph32395.khopro.Model.NhanVien;
import com.ph32395.khopro.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class HoaDonThanhToanFragment extends Fragment {
    TextView tv_maHoaDon_hoaDon, tv_soBan_hoaDon, tv_gioTao_hoaDon, tv_maNhanVien_hoaDon, tv_ngayTao_hoaDon, tv_thanhTien_hoaDon, tv_giamGia_hoaDon, tv_truTien_hoaDon, tv_tongTien_hoaDon;

    ListView lv_hoaDon_ThanhToan;
    private ArrayList<ChiTietHoaDon> list;

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
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("LuuMaHoaDon", Context.MODE_PRIVATE);

        String maHoaDonChiTiet = sharedPreferences.getString("maHoaDon", "-1");
        int maHoaDonint = Integer.parseInt(maHoaDonChiTiet);

        ChiTietHoaDonDAO hoaDonChiTietDAO = new ChiTietHoaDonDAO(getContext());


        if (maHoaDonint!=-1){
            List<ChiTietHoaDon> listHoaDonChiTiet = hoaDonChiTietDAO.getIdChiTietHoaDonByRowId(maHoaDonint);
            if (!listHoaDonChiTiet.isEmpty()) {
                HoaDonChiTietAdapter hoaDonChiTietAdapter = new HoaDonChiTietAdapter(getContext(), listHoaDonChiTiet);
                lv_hoaDon_ThanhToan.setAdapter(hoaDonChiTietAdapter);
                int totalAmount = calculateTotalAmount(listHoaDonChiTiet);
                tv_thanhTien_hoaDon.setText(String.valueOf(formatMoney(totalAmount)));
                SharedPreferences getPhanTram = getActivity().getSharedPreferences("gGsave", Context.MODE_PRIVATE);
                int phantramgg = getPhanTram.getInt("PhanTram",0);
                tv_giamGia_hoaDon.setText(String.valueOf(phantramgg));
                int tongtien = (totalAmount * phantramgg) / 100;
                tv_truTien_hoaDon.setText(String.valueOf(formatMoney(tongtien)));
                int giamtien = totalAmount-tongtien;
                tv_tongTien_hoaDon.setText(String.valueOf(formatMoney(giamtien)));

            } else {
                Toast.makeText(getContext(), "Rỗng", Toast.LENGTH_SHORT).show();
            }


        }


        displayDataFromSharedPreferences();

        return v;
    }

    private void displayDataFromSharedPreferences() {
        // Lấy dữ liệu từ SharedPreferences
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("LuuMaHoaDon", Context.MODE_PRIVATE);
        SharedPreferences getNV = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences getSB = getActivity().getSharedPreferences("SoBanSave", Context.MODE_PRIVATE);
        SharedPreferences getGio = getActivity().getSharedPreferences("GioSave", Context.MODE_PRIVATE);
        SharedPreferences getNgay = getActivity().getSharedPreferences("NgaySave", Context.MODE_PRIVATE);




        // Lấy và hiển thị mã hóa đơn
        String maHoaDon = sharedPreferences.getString("maHoaDon", "");
        tv_maHoaDon_hoaDon.setText(maHoaDon);
        SharedPreferences svghichu = getActivity().getSharedPreferences("ghiChuSave", Context.MODE_PRIVATE);
        String ghiChu = svghichu.getString("GhiChu", "");

        String manv = getNV.getString("mma","");
        NhanVienDAO nvDao = new NhanVienDAO(getContext());
        NhanVien nv = nvDao.getID(manv);
        String tenNV = nv.getHoTen();
        tv_maNhanVien_hoaDon.setText(tenNV);

        String ngay = getNgay.getString("Ngay","");
        String gio = getGio.getString("Gio","");
        int soBan = getSB.getInt("SoBan",0);
        if (soBan==0){
            tv_soBan_hoaDon.setText("Mang Về");

        }else {
            tv_soBan_hoaDon.setText(String.valueOf(soBan));
        }
        tv_gioTao_hoaDon.setText(gio);
        tv_ngayTao_hoaDon.setText(ngay);





    }
    private int calculateTotalAmount(List<ChiTietHoaDon> chiTietHoaDonList) {
        int totalAmount = 0;
        for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDonList) {
            totalAmount += (chiTietHoaDon.getGiaTien()*chiTietHoaDon.getSoLuong());
        }
        return totalAmount;
    }
    private String formatMoney(int money) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(money);
    }

}
