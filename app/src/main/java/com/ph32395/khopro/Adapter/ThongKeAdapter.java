package com.ph32395.khopro.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ph32395.khopro.Model.ChiTietHoaDon;
import com.ph32395.khopro.Model.MonAnDaBan;
import com.ph32395.khopro.R;

import java.util.List;

public class ThongKeAdapter extends RecyclerView.Adapter<ThongKeAdapter.ViewHolder> {

    private List<MonAnDaBan> monAnList;

    public ThongKeAdapter(List<MonAnDaBan> monAnList) {
        this.monAnList = monAnList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thongke_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MonAnDaBan monAn = monAnList.get(position);
        holder.txtTenMonAn.setText(monAn.getTenMonAn());
        holder.txtSoLuongDaBan.setText(String.valueOf(monAn.getTongSoLuong()));
    }

    @Override
    public int getItemCount() {
        return monAnList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTenMonAn;
        TextView txtSoLuongDaBan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenMonAn = itemView.findViewById(R.id.txtTenMonAn);
            txtSoLuongDaBan = itemView.findViewById(R.id.txtSoLuongDaBan);
        }
    }
}

