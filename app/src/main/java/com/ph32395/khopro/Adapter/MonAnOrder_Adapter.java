package com.ph32395.khopro.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ph32395.khopro.DAO.MonAnDAO;
import com.ph32395.khopro.Model.MonAn;
import com.ph32395.khopro.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MonAnOrder_Adapter extends RecyclerView.Adapter<MonAnOrder_Adapter.ViewHolder> {
    Context context;
    ArrayList<MonAn> list;
    MonAnDAO monAnDAO;
    MonAn monAn;



    public MonAnOrder_Adapter(Context context , ArrayList<MonAn> list){
        this.context = context;
        this.list = list;
        monAnDAO = new MonAnDAO(context);
    }


    @NonNull
    @Override
    public MonAnOrder_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_order_monan, parent, false);
        return new MonAnOrder_Adapter.ViewHolder(view);
    }
    private String formatMoney(int money) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(money);
    }

    @Override
    public void onBindViewHolder(@NonNull MonAnOrder_Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final MonAn monAn1 = list.get(position);
        holder.tv_tenMonAnOrder.setText(list.get(position).getTenMonAn());
        holder.tv_giaMonAnOrder.setText(formatMoney((int) list.get(position).getGiaTien())+"");
        final int[] soluong = {0};
        holder.btn_themDoAnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soluong[0] = soluong[0] +1;
                holder.tv_giaMonAnOrder.setText(formatMoney((int)(list.get(position).getGiaTien()* soluong[0]))+"");
                holder.tv_soLuong.setText(soluong[0] +"");
            }
        });
        holder.btn_giamDoAnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soluong[0] = soluong[0] -1;
                if (soluong[0] <0){
                    soluong[0] = soluong[0] +1;
                }
                holder.tv_giaMonAnOrder.setText(formatMoney((int)(list.get(position).getGiaTien()* soluong[0]))+"");
                holder.tv_soLuong.setText(soluong[0] +"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tenMonAnOrder , tv_giaMonAnOrder , tv_soLuong;
        ImageButton btn_giamDoAnOrder , btn_themDoAnOrder;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_tenMonAnOrder = itemView.findViewById(R.id.tv_tenMonAnOrder);
            tv_soLuong = itemView.findViewById(R.id.tv_soLuong);
            tv_giaMonAnOrder = itemView.findViewById(R.id.tv_giaMonAnOrder);

            btn_themDoAnOrder = itemView.findViewById(R.id.btn_themDoAnOrder);
            btn_giamDoAnOrder = itemView.findViewById(R.id.btn_giamDoAnOrder);
        }
    }
}
