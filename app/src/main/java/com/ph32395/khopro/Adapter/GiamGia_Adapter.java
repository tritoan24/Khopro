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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.ph32395.khopro.DAO.GiamGiaDAO;
import com.ph32395.khopro.Model.GiamGia;
import com.ph32395.khopro.R;

import java.util.List;

public class GiamGia_Adapter extends RecyclerView.Adapter<GiamGia_Adapter.ViewHolder>{
    Context context;
    List<GiamGia> list;
    GiamGia giamGia;
    GiamGiaDAO giamGiaDAO;

    public GiamGia_Adapter(Context context ,List<GiamGia> list){
        this.context = context;
        this.list=list;
    }

    @NonNull
    @Override
    public GiamGia_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_giamgia,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GiamGia_Adapter.ViewHolder holder, int position) {
        GiamGia giamGia1 = list.get(position);
        holder.txtIDGiamGia.setText(giamGia1.getId_GiamGia()+"");
        holder.txtMaGiamGia.setText(giamGia1.getMaGiamGia());
        holder.txtMucGiamGia.setText(giamGia1.getPhanTramGiam()+"");
        holder.txtSoLuotDung.setText(giamGia1.getSoLuotDung()+"");

        holder.img_edit_GG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Update(giamGia1);
            }
        });
        holder.img_delete_GG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete(giamGia1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtIDGiamGia , txtMaGiamGia,txtMucGiamGia, txtSoLuotDung;
        ImageView img_edit_GG , img_delete_GG;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtIDGiamGia = itemView.findViewById(R.id.txtIDGiamGia);
            txtMaGiamGia = itemView.findViewById(R.id.txtMaGiamGia);
            txtMucGiamGia = itemView.findViewById(R.id.txtMucGiamGia);
            txtSoLuotDung = itemView.findViewById(R.id.txtSoLuotDung);
            img_edit_GG = itemView.findViewById(R.id.img_edit_GG);
            img_delete_GG = itemView.findViewById(R.id.img_delete_GG);
        }
    }
    public void Delete(GiamGia giamGia){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(android.R.drawable.ic_delete);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn xóa không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                giamGiaDAO = new GiamGiaDAO(context);
                int kq = giamGiaDAO.Delete(giamGia);
                if(kq>0){
                    Toast.makeText(context, "xóa thành công", Toast.LENGTH_SHORT).show();
                    list.clear();
                    list.addAll(giamGiaDAO.getAll());
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

    public void Update(GiamGia giamGia){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View v = inflater.inflate(R.layout.update_giamgia,null);
        builder.setView(v);
        builder.setCancelable(false);
        AlertDialog dialog = builder.create();

        EditText ed_updateMaGiamGia = v.findViewById(R.id.ed_maGG_update);
        EditText ed_updateMucGiamGia = v.findViewById(R.id.ed_MucGiam_update);
        EditText ed_updateSoLuotDung = v.findViewById(R.id.ed_soLuotDung_update);
        Button btn_updateGG = v.findViewById(R.id.btn_SuaGG_update);
        Button btn_huyupdateGG = v.findViewById(R.id.btn_huySuaGG_update);

        GiamGiaDAO giamGiaDAO1 = new GiamGiaDAO(context);
        List<GiamGia> list1 = giamGiaDAO1.getAll();
        ed_updateMaGiamGia.setText(giamGia.getMaGiamGia());
        ed_updateMucGiamGia.setText(giamGia.getPhanTramGiam()+"");
        ed_updateSoLuotDung.setText(giamGia.getSoLuotDung()+"");

        btn_updateGG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String magiamgia = ed_updateMaGiamGia.getText().toString();
                int mucgiamgia = Integer.parseInt(ed_updateMucGiamGia.getText().toString());
                int soluotdung = Integer.parseInt(ed_updateSoLuotDung.getText().toString());

                giamGiaDAO = new GiamGiaDAO(context);
                giamGia.setMaGiamGia(magiamgia);
                giamGia.setPhanTramGiam(mucgiamgia);
                giamGia.setSoLuotDung(soluotdung);

                int kq = giamGiaDAO.Update(giamGia);
                if(kq>0){
                    Toast.makeText(context, "update thành công", Toast.LENGTH_SHORT).show();
                    list.clear();
                    list.addAll(giamGiaDAO.getAll());
                    notifyDataSetChanged();
                    ed_updateMaGiamGia.setText("");
                    ed_updateMucGiamGia.setText("");
                    ed_updateSoLuotDung.setText("");
                    dialog.dismiss();
                }else {
                    Toast.makeText(context, "ko update dc", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        btn_huyupdateGG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "hủy update", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
