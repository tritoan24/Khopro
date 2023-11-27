package com.ph32395.khopro.Adapter;

import android.app.Activity;
import android.app.Dialog;
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
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.ph32395.khopro.DAO.DanhMucDAO;
import com.ph32395.khopro.Model.DanhMucMonAn;
import com.ph32395.khopro.R;

import java.util.ArrayList;

public class DanhMuc_Adapter extends RecyclerView.Adapter<DanhMuc_Adapter.ViewHolder> {

    Context context;
    ArrayList<DanhMucMonAn> listDM;
    DanhMucDAO danhMucDAO;

    EditText ed_maDanhMuc_update, ed_tenDanhMuc_update;

    public DanhMuc_Adapter(Context context, ArrayList<DanhMucMonAn> listDM) {
        this.context = context;
        this.listDM = listDM;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_danhmuc, parent, false);
        return new DanhMuc_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_maDanhMuc.setText(listDM.get(position).getId_DanhMuc());
        holder.tv_tenDanhMuc.setText(String.valueOf(listDM.get(position).getTenDanhMuc()));
        holder.img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogThemDanhMuc(holder.getAdapterPosition());
            }
        });
        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogXoaDanhMuc(holder.getAdapterPosition());
            }
        });
    }


    @Override
    public int getItemCount() {
        return listDM.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_maDanhMuc, tv_tenDanhMuc;
        ImageView img_edit, img_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_maDanhMuc = itemView.findViewById(R.id.tv_maDanhMuc);
            tv_tenDanhMuc = itemView.findViewById(R.id.tv_tenDanhMuc);
            img_edit = itemView.findViewById(R.id.img_edit_danhMuc);
            img_delete = itemView.findViewById(R.id.img_delete_danhMuc);
        }
    }

    public void dialogThemDanhMuc(int viTri) {
        DanhMucMonAn danhMucMonAn = listDM.get(viTri);
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.update_danhmuc);


        Button btn_themDanhMuc_update, btn_huyThemDanhMuc_update;
        ed_maDanhMuc_update = dialog.findViewById(R.id.ed_maDanhMuc_update);
        ed_tenDanhMuc_update = dialog.findViewById(R.id.ed_tenDanhMuc_update);
        btn_themDanhMuc_update = dialog.findViewById(R.id.btn_themDanhMuc_update);
        btn_huyThemDanhMuc_update = dialog.findViewById(R.id.btn_huyThemDanhMuc_update);

        ed_maDanhMuc_update.setText(danhMucMonAn.getId_DanhMuc() + "");
        ed_tenDanhMuc_update.setText(danhMucMonAn.getTenDanhMuc());

        btn_themDanhMuc_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                danhMucDAO = new DanhMucDAO(context);
                if (validate() > 0) {
                    danhMucMonAn.setId_DanhMuc(Integer.parseInt(ed_maDanhMuc_update.getText().toString()));
                    danhMucMonAn.setTenDanhMuc(ed_tenDanhMuc_update.getText().toString());
                    if (danhMucDAO.update(danhMucMonAn) > 0) {
                        listDM.clear();
                        listDM = danhMucDAO.getListDanhMuc();
                        notifyDataSetChanged();
                        Toast.makeText(context, "Sửa thành công", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    } else {
                        Toast.makeText(context, "Sửa thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btn_huyThemDanhMuc_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed_maDanhMuc_update.setText("");
                ed_tenDanhMuc_update.setText("");
            }
        });
        dialog.show();
    }

    private void dialogXoaDanhMuc(int viTri) {
        new AlertDialog.Builder(context)
                .setTitle("Confirm")
                .setMessage("Bạn có chắc chắn muốn xoá không?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // xoa
                        danhMucDAO = new DanhMucDAO(context);
                        if(danhMucDAO.delete(Integer.parseInt(String.valueOf(listDM.get(viTri).getId_DanhMuc())))>0){
                            listDM.clear();
                            listDM = danhMucDAO.getListDanhMuc();
                            notifyDataSetChanged();
                            Toast.makeText(context, "Xoá thành công", Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(context, "Xoá thất bại", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    public int validate() {
        int check = 1;
        if (ed_maDanhMuc_update.getText().length() == 0 || ed_tenDanhMuc_update.getText().length() == 0) {
            Toast.makeText(context, "Không bỏ trống", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }
}
