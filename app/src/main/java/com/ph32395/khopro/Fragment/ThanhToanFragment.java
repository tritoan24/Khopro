package com.ph32395.khopro.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ph32395.khopro.DAO.BoNhoTamThoiDAO;
import com.ph32395.khopro.DAO.GiamGiaDAO;
import com.ph32395.khopro.DAO.HoaDonDAO;
import com.ph32395.khopro.DAO.NhanVienDAO;
import com.ph32395.khopro.Model.HoaDon;
import com.ph32395.khopro.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ThanhToanFragment extends Fragment {

    Button btn_thanhToanTienMat , btn_thanhToanChuyenKhoan , btn_thanhToanTheNganHang,btn_quayLaiMonAn , btn_tiepTuc;
    EditText ed_maGiamGiaThanhToan , ed_ghiChu;
    String phuongThuc = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_thanhtoan, container, false);

        btn_thanhToanTienMat = v.findViewById(R.id.btn_thanhToanTienMat);
        btn_thanhToanChuyenKhoan = v.findViewById(R.id.btn_thanhToanChuyenKhoan);
        btn_thanhToanTheNganHang = v.findViewById(R.id.btn_thanhToanTheNganHang);
        btn_quayLaiMonAn = v.findViewById(R.id.btn_quayLaiMonAn);
        btn_tiepTuc = v.findViewById(R.id.btn_tiepTuc);
        ed_maGiamGiaThanhToan = v.findViewById(R.id.ed_maGiamGiaThanhToan);
        ed_ghiChu = v.findViewById(R.id.ed_giChu);

        btn_thanhToanChuyenKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phuongThuc = "Chuyển Khoản";
                btn_thanhToanTheNganHang.setBackgroundColor(getResources().getColor(R.color.white));
                // Reset background color of other buttons
                btn_thanhToanTienMat.setBackgroundColor(getResources().getColor(R.color.white));
                btn_thanhToanChuyenKhoan.setBackgroundColor(getResources().getColor(R.color.xanh));
            }
        });
        btn_thanhToanTienMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phuongThuc = "Tiền Mặt";
                btn_thanhToanTheNganHang.setBackgroundColor(getResources().getColor(R.color.white));
                // Reset background color of other buttons
                btn_thanhToanTienMat.setBackgroundColor(getResources().getColor(R.color.xanh));
                btn_thanhToanChuyenKhoan.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });
        btn_thanhToanTheNganHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phuongThuc = "Thẻ Ngân Hàng";
                btn_thanhToanTheNganHang.setBackgroundColor(getResources().getColor(R.color.xanh));
                // Reset background color of other buttons
                btn_thanhToanTienMat.setBackgroundColor(getResources().getColor(R.color.white));
                btn_thanhToanChuyenKhoan.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });




        btn_tiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maGG = ed_maGiamGiaThanhToan.getText().toString().trim();
                String ghiChu = ed_ghiChu.getText().toString().trim();


                String manv = readMmaFromSharedPreferences();

                int soBan = getSoBanFromSharedPreferences();

                String ngay = getCurrentDateTime();
                String gio = getGio();

                saveGhiChuToSharedPreferences(ghiChu);

                GiamGiaDAO ggDao = new GiamGiaDAO(getContext());
                boolean maGGTonTai = ggDao.kiemTraMaGiamGiaTonTai(maGG);

                if (maGGTonTai) {
                    int phanTramGiam = ggDao.layPhanTramGiamTuMaGiamGia(maGG);
                    Toast.makeText(getContext(), "Mã Giảm giá hợp lệ. Phần trăm giảm: " + phanTramGiam + "%", Toast.LENGTH_SHORT).show();
                    ggDao.giamSoLuotDung(maGG);
                    int soLuotDung = ggDao.laySoLuotDungTuMaGiamGia(maGG);

                } else {
                    Toast.makeText(getContext(), "Mã Giảm Giá Không Hợp lệ", Toast.LENGTH_SHORT).show();
                }

                int tongTien = getTongTienToShareFrence();



                HoaDon hoaDon = new HoaDon();
                hoaDon.setId_NhanVien(manv);
                hoaDon.setSoBan(soBan);
                hoaDon.setNgayGio(ngay);
                hoaDon.setKieuThanhToan(phuongThuc);
                hoaDon.setTongTien(tongTien);

                // Insert HoaDon into the database
                HoaDonDAO hoaDonDAO = new HoaDonDAO(getContext());
                long insertedRowId = hoaDonDAO.Insert(hoaDon);

                // Check if the insertion was successful
                if (insertedRowId != -1) {
                    Toast.makeText(getContext(), "Hóa đơn được tạo thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Không thể tạo hóa đơn", Toast.LENGTH_SHORT).show();
                }



            }
        });
        return v;
    }
    private int getSoBanFromSharedPreferences() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("SoBanSave", Context.MODE_PRIVATE);
        return sharedPreferences.getInt("SoBan", 0); // Giá trị mặc định là 0 nếu không tìm thấy
    }
    private String readMmaFromSharedPreferences() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        return sharedPreferences.getString("mma", "");
    }
    private String getCurrentDateTime() {
        // Lấy thời gian hiện tại
        Calendar calendar = Calendar.getInstance();
        // Định dạng ngày và giờ
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        // Lấy ngày và giờ
        String ngay = dateFormat.format(calendar.getTime());

        return ngay ;
    }
    private String getGio(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String gio = timeFormat.format(calendar.getTime());
        return gio;

    }
    private void saveGhiChuToSharedPreferences(String GhiChu) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("ghiChuSave", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Lưu giá trị số bàn vào SharedPreferences
        editor.putString("GhiChu", GhiChu);
        editor.apply();
    }
    private int getTongTienToShareFrence() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("TongTien", Context.MODE_PRIVATE);
        return sharedPreferences.getInt("TongTien",0); // Giá trị mặc định là 0 nếu không tìm thấy
    }
}
