package com.ph32395.khopro.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.TimedText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ph32395.khopro.DAO.BanAnDAO;
import com.ph32395.khopro.Model.BanAn;
import com.ph32395.khopro.R;

import java.util.ArrayList;

public class BanAn_Adapter extends RecyclerView.Adapter<BanAn_Adapter.ViewHolder>{
    Context context;
    ArrayList<BanAn> list;

    public BanAn_Adapter(Context context, ArrayList<BanAn> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_banan,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_banAn.setText(String.valueOf(list.get(position).getSoBan()));
        holder.tv_trangThai.setText(String.valueOf(list.get(position).getTrangThai()));
        holder.img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                LayoutInflater inflater = ((Activity)context).getLayoutInflater();
                View view = inflater.inflate(R.layout.update_loaisach,null);
                builder.setView(view);
                Dialog dialog = builder.create();
                dialog.show();
            }
        });
        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Xóa loại sách");
                builder.setCancelable(false);
                builder.setMessage("Bạn có chắc chắn muốn xoá không ?");

                builder.setNegativeButton("Huỷ", null);

                builder.setPositiveButton("Xoá", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_banAn, tv_trangThai;
        ImageView img_edit, img_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_banAn = itemView.findViewById(R.id.tv_banAn);
            tv_trangThai = itemView.findViewById(R.id.tv_trangThai);
            img_edit = itemView.findViewById(R.id.img_edit);
            img_delete = itemView.findViewById(R.id.img_delete);
        }
    }
}
