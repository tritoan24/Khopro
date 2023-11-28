package com.ph32395.khopro.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ph32395.khopro.DAO.DanhMucDAO;
import com.ph32395.khopro.DAO.GiamGiaDAO;
import com.ph32395.khopro.DAO.MonAnDAO;
import com.ph32395.khopro.Model.GiamGia;
import com.ph32395.khopro.Model.MonAn;
import com.ph32395.khopro.R;

import java.util.ArrayList;
import java.util.List;

public class MonAn_Adapter extends RecyclerView.Adapter<MonAn_Adapter.ViewHolder>{
    Context context;
    ArrayList<MonAn> list;
    MonAnDAO monAnDAO;

    public MonAn_Adapter(Context context, ArrayList<MonAn> list) {
        this.context = context;
        this.list = list;
        monAnDAO = new MonAnDAO(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_monan, parent, false);
        return new MonAn_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MonAn monAn1 = list.get(position);
        holder.tv_maMonAn.setText(list.get(position).getId_MonAn());
        holder.tv_tenMonAn.setText(list.get(position).getTenMonAn());
        holder.tv_loaiMon.setText(list.get(position).getId_DanhMuc());
        holder.tv_giamGiaMon.setText(list.get(position).getId_GiamGia());
        holder.tv_giaMonAn.setText((int) list.get(position).getGiaTien());
        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogXoaMonAn(monAn1);
            }
        });

        holder.img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogSuaMonAn(monAn1);
            }


        });
    }

    private void dialogXoaMonAn(MonAn monAn) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setIcon(android.R.drawable.ic_delete);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn xóa không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                monAnDAO = new MonAnDAO(context);
                int kq = monAnDAO.Delete(monAn);
                if(kq>0){
                    Toast.makeText(context, "xóa thành công", Toast.LENGTH_SHORT).show();
                    list.clear();
                    list.addAll(monAnDAO.getAll());
                    notifyDataSetChanged();
                    dialog.dismiss();
                }else {
                    Toast.makeText(context, "xóa không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "hủy xóa", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();


    }

    private void dialogSuaMonAn(MonAn monAn) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View v = inflater.inflate(R.layout.update_monan,null);
        builder.setView(v);
        builder.setCancelable(false);
        AlertDialog dialog = builder.create();

        EditText ed_maMonAn_update = v.findViewById(R.id.ed_maMonAn_update);
        EditText ed_tenMonAn_update = v.findViewById(R.id.ed_tenMonAn_update);
        EditText ed_tenDanhMuc_MonAn_update = v.findViewById(R.id.ed_tenDanhMuc_MonAn_update);
        EditText ed_maGiamGia_MonAn_update = v.findViewById(R.id.ed_maGiamGia_MonAn_update);
        EditText ed_giaMon_update = v.findViewById(R.id.ed_giaMon_update);

        Button btn_updateMA = v.findViewById(R.id.btn_themMonAn_update);
        Button btn_huyupdateMA = v.findViewById(R.id.btn_huyThemMonAn_update);

        MonAnDAO monAnDAO1 = new MonAnDAO(context);
        List<MonAn> list1 = monAnDAO1.getAll();
        ed_maMonAn_update.setText(monAn.getId_MonAn()+"");
        ed_tenMonAn_update.setText(monAn.getTenMonAn());
        ed_tenDanhMuc_MonAn_update.setText(monAn.getId_DanhMuc()+"");
        ed_maGiamGia_MonAn_update.setText(monAn.getId_GiamGia()+"");
        ed_giaMon_update.setText(monAn.getGiaTien()+"");

        btn_updateMA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ma_monAn = Integer.parseInt(ed_maMonAn_update.getText().toString());
                String ten_monAn = ed_tenMonAn_update.getText().toString();
                int id_danhMuc = Integer.parseInt(ed_tenDanhMuc_MonAn_update.getText().toString());
                Integer id_maGiamGia = Integer.valueOf(ed_maGiamGia_MonAn_update.getText().toString());
                double giaTien = Double.parseDouble(ed_giaMon_update.getText().toString());

                monAnDAO = new MonAnDAO(context);
                monAn.setId_MonAn(ma_monAn);
                monAn.setTenMonAn(ten_monAn);
                monAn.setId_DanhMuc(id_danhMuc);
                monAn.setId_GiamGia(id_maGiamGia);
                monAn.setGiaTien(giaTien);

                int kq = monAnDAO.Update(monAn);
                if(kq>0){
                    Toast.makeText(context, "update thành công", Toast.LENGTH_SHORT).show();
                    list.clear();
                    list.addAll(monAnDAO.getAll());
                    notifyDataSetChanged();
                    ed_maMonAn_update.setText("");
                    ed_tenMonAn_update.setText("");
                    ed_tenDanhMuc_MonAn_update.setText("");
                    ed_maGiamGia_MonAn_update.setText("");
                    ed_giaMon_update.setText("");
                    dialog.dismiss();
                }else {
                    Toast.makeText(context, "update thất bại", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        btn_huyupdateMA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "hủy update", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_maMonAn, tv_tenMonAn, tv_loaiMon, tv_giamGiaMon, tv_giaMonAn;
        ImageView img_edit, img_delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_maMonAn = itemView.findViewById(R.id.tv_maMonAn);
            tv_tenMonAn = itemView.findViewById(R.id.tv_tenMonAn);
            tv_loaiMon = itemView.findViewById(R.id.tv_loaiMonAn);
            tv_giamGiaMon = itemView.findViewById(R.id.tv_giamGiaMon);
            tv_giaMonAn = itemView.findViewById(R.id.tv_giaTienMon);

            img_delete = itemView.findViewById(R.id.img_delete_monAn);
            img_edit = itemView.findViewById(R.id.img_edit_monAn);

        }
    }


}
