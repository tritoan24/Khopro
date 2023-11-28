package com.ph32395.khopro.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.ph32395.khopro.Adapter.NhanVien_Adapter;
import com.ph32395.khopro.DAO.NhanVienDAO;
import com.ph32395.khopro.Model.NhanVien;
import com.ph32395.khopro.R;

import java.util.List;


public class QLNhanVienFragment extends Fragment {
    RecyclerView recyclerView;
    NhanVien_Adapter nhanVienAdapter;
    NhanVienDAO dao;
    ImageView img_add_nhanVien;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_q_l_nhan_vien, container, false);


        // Khởi tạo RecyclerView và Adapter
        recyclerView = view.findViewById(R.id.rc_quanLyNhanVien);
        nhanVienAdapter = new NhanVien_Adapter(getContext(), getNhanVienData()); // Sử dụng hàm lấy dữ liệu từ cơ sở dữ liệu

        // Thiết lập RecyclerView và Adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(nhanVienAdapter);


        img_add_nhanVien = view.findViewById(R.id.img_add_nhanVien);
        img_add_nhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo một hộp thoại để nhập thông tin nhân viên
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = requireActivity().getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.add_nhanvien, null);

                // Ánh xạ các thành phần của hộp thoại
                EditText edmaNV = dialogView.findViewById(R.id.ed_maNhanVien);
                EditText edtHoTen = dialogView.findViewById(R.id.edhoten_nv);
                EditText edTuoi = dialogView.findViewById(R.id.ed_tuoiNhanVien);
//                RadioButton gioiTinh = dialogView.findViewById(R.id.gi)
                EditText edsoDienThoai = dialogView.findViewById(R.id.ed_sdtNhanVien);
                EditText edmatKhau = dialogView.findViewById(R.id.ed_matKhau_nv);
                Button btnaddnv = dialogView.findViewById(R.id.btn_themNhanVien);
                Button btnhuythemnv = dialogView.findViewById(R.id.btn_huyThemNhanVien);

                btnhuythemnv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
//                btnaddnv.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        String maNhanVien = edmaNV.getText().toString().trim();
//                        String hoTen = edtHoTen.getText().toString().trim();
//                        String tuoi = edTuoi.getText().toString().trim();
////                        String gioitinh;
//                        String sodienthoai = edsoDienThoai.getText().toString().trim();
//                        String matkhau = edmatKhau.getText().toString().trim();
//
//                        // Kiểm tra xem các trường dữ liệu có hợp lệ không
//                        if (!TextUtils.isEmpty(maNhanVien) && !TextUtils.isEmpty(hoTen)&& !TextUtils.isEmpty(tuoi)&& !TextUtils.isEmpty(sodienthoai)&& !TextUtils.isEmpty(matkhau)) {
//                            // Tạo một đối tượng NhanVien mới
//                            NhanVien newNhanVien = new NhanVien();
//                            newNhanVien.setMaNhanVien(maNhanVien);
//                            newNhanVien.setHoTen(hoTen);
//                            // Đặt các giá trị cho các trường khác...
//
//                            // Gọi hàm thêm mới từ DAO
//                            long result = nhanVienDAO.insert(newNhanVien);
//                            if (result > 0) {
//                                // Thêm mới thành công, làm gì đó nếu cần
//                                Toast.makeText(getActivity(), "Thêm mới thành công", Toast.LENGTH_SHORT).show();
//                                // Cập nhật danh sách hiển thị nếu cần
//                                updateRecyclerView();
//                            } else {
//                                // Thêm mới thất bại, làm gì đó nếu cần
//                                Toast.makeText(getActivity(), "Thêm mới thất bại", Toast.LENGTH_SHORT).show();
//                            }
//                        } else {
//                            // Hiển thị thông báo hoặc xử lý khi dữ liệu không hợp lệ
//                            Toast.makeText(getActivity(), "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//
//
//                // Thiết lập hộp thoại
//                builder.setView(dialogView)
//                        .setTitle("Thêm Nhân Viên")
//                        .setPositiveButton("Thêm", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                // Lấy dữ liệu từ các EditText
//
//                            }
//                        })
//                        .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                // Đóng hộp thoại nếu người dùng chọn Hủy
//                                dialog.dismiss();
//                            }
//                        });
//
//                // Hiển thị hộp thoại
//                builder.show();
         }
        });

        return view;
    }
    private List<NhanVien> getNhanVienData() {
        // Gọi hàm lấy dữ liệu từ cơ sở dữ liệu thông qua đối tượng DAO
        dao = new NhanVienDAO(getContext());
        return dao.getAll(); // Giả sử nhanVienDAO đã được khởi tạo và có phương thức getAll()
    }
}
