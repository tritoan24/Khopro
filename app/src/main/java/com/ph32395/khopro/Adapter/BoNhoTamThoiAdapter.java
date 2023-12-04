package com.ph32395.khopro.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.daimajia.swipe.SwipeLayout;
import com.ph32395.khopro.DAO.BoNhoTamThoiDAO;
import com.ph32395.khopro.Model.BoNhoTamThoi;
import com.ph32395.khopro.R;

import java.text.DecimalFormat;
import java.util.List;

public class BoNhoTamThoiAdapter extends ArrayAdapter<BoNhoTamThoi> {
    private Context context;
    private int resource;

    public BoNhoTamThoiAdapter(Context context, int resource, List<BoNhoTamThoi> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        try {
            if (row == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                row = inflater.inflate(resource, parent, false);
            }

            BoNhoTamThoi boNhoTamThoi = getItem(position);

            if (boNhoTamThoi != null) {
                TextView tvTenMonAn = row.findViewById(R.id.tvTenMonAn);
                TextView tvSoLuong = row.findViewById(R.id.tvSoLuong);
                TextView tvThanhTien = row.findViewById(R.id.tvThanhTien);

                tvTenMonAn.setText(boNhoTamThoi.getTenMonAn());
                tvSoLuong.setText(String.valueOf(boNhoTamThoi.getSoLuong()));
                tvThanhTien.setText(String.valueOf(formatMoney(boNhoTamThoi.getThanhTien())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        row.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                BoNhoTamThoiDAO dao = new BoNhoTamThoiDAO(getContext());
                BoNhoTamThoi boNhoTamThoi = getItem(position);

                if (boNhoTamThoi != null) {
                    // Gọi phương thức xóa trong DAO
                    dao.delete(boNhoTamThoi.getId_BoNho());

                    // Xóa mục trong danh sách
                    remove(boNhoTamThoi);

                    // Thông báo sự kiện đã xóa mục tại vị trí position
                    notifyDataSetChanged();
                }

                return true;
            }
        });

        return row;
    }
    private String formatMoney(int money) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        return decimalFormat.format(money);
    }
    private void deleteItem(int position) {
        // Xử lý xóa mục từ cơ sở dữ liệu
        BoNhoTamThoi boNhoTamThoi = getItem(position);
        if (boNhoTamThoi != null) {
            // Xóa mục từ cơ sở dữ liệu ở đây (thay thế bằng logic thích hợp)
            // dbHelper.deleteItem(boNhoTamThoi.getId());

            // Xóa mục trong danh sách
            remove(boNhoTamThoi);

            // Thông báo sự kiện đã xóa mục tại vị trí position
            notifyDataSetChanged();
        }
    }

}

