package com.ph32395.khopro.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ph32395.khopro.Model.NhanVien;
import com.ph32395.khopro.R;

import java.util.List;

public class NhanVien_Adapter extends RecyclerView.Adapter<NhanVien_Adapter.ViewHolder> {
    private Context context;
    private List<NhanVien> nhanVienList;

    public NhanVien_Adapter(Context context, List<NhanVien> nhanVienList) {
        this.context = context;
        this.nhanVienList = nhanVienList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_nhanvien, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NhanVien nhanVien = nhanVienList.get(position);

        // Set data to views
        holder.tvMaNhanVien.setText("Mã Nhân Viên: " + nhanVien.getMaNhanVien());
        holder.tvHoTen.setText("Họ Tên: " + nhanVien.getHoTen());
        holder.tvTuoi.setText("Tuổi: " + String.valueOf(nhanVien.getTuoi()));
        holder.tvGioiTinh.setText("Giới Tính: " + nhanVien.getGioiTinh());
        holder.tvSoDienThoai.setText("Số Điện Thoại: " + nhanVien.getSoDienThoai());
        holder.tvMatKhau.setText("Mật Khẩu: " + nhanVien.getMatKhau());

        // Set click listeners for edit and delete buttons
        holder.btimgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle edit button click
                // You can implement your logic here
            }
        });

        holder.btimgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle delete button click
                // You can implement your logic here
            }
        });
    }

    @Override
    public int getItemCount() {
        return nhanVienList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMaNhanVien, tvHoTen, tvTuoi, tvGioiTinh, tvSoDienThoai, tvMatKhau;
        ImageButton btimgEdit, btimgDelete;
        CardView cardView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMaNhanVien = itemView.findViewById(R.id.tvMaNhanVien);
            tvHoTen = itemView.findViewById(R.id.tvHoTen);
            tvTuoi = itemView.findViewById(R.id.tvTuoi);
            tvGioiTinh = itemView.findViewById(R.id.tvGioiTinh);
            tvSoDienThoai = itemView.findViewById(R.id.tvSoDienThoai);
            tvMatKhau = itemView.findViewById(R.id.tvMatKhau);
            btimgEdit = itemView.findViewById(R.id.btimg_edit);
            btimgDelete = itemView.findViewById(R.id.btimg_delete);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
