package com.ph32395.khopro.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.ph32395.khopro.DAO.GiamGiaDAO;
import com.ph32395.khopro.DAO.HoaDonDAO;
import com.ph32395.khopro.DAO.MonAnDAO;
import com.ph32395.khopro.Fragment.QLHoaDonFragment;
import com.ph32395.khopro.Model.GiamGia;
import com.ph32395.khopro.Model.HoaDon;
import com.ph32395.khopro.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class HoaDon_Adapter extends RecyclerView.Adapter<HoaDon_Adapter.ViewHolder> {
    Context context;
    private ArrayList<HoaDon> list;

    HoaDonDAO hoaDonDAO;

    GiamGiaDAO giamGiaDAO;

    QLHoaDonFragment hoaDonFragment;

    public HoaDon_Adapter(Context context, QLHoaDonFragment hoaDonFragment, ArrayList<HoaDon> list) {
        this.context = context;
        this.list = list;
        this.hoaDonFragment = hoaDonFragment;
        hoaDonDAO = new HoaDonDAO(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_hoadon, parent, false);
        return new HoaDon_Adapter.ViewHolder(view);
    }

    private String formatMoney(int money) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(money);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final HoaDon hoaDon1 = list.get(position);
        holder.tv_maHoaDon.setText(list.get(position).getId_HoaDon()+"");
        holder.tv_maMonAn.setText(list.get(position).getId_MonAn()+"");
        holder.tv_maNhanVien.setText(list.get(position).getId_NhanVien());
        holder.tv_soBan.setText(list.get(position).getId_BanAn());

        giamGiaDAO = new GiamGiaDAO(context);
        GiamGia gg = giamGiaDAO.getID(String.valueOf(hoaDon1.getId_GiamGia()));
        if (gg != null) {
            holder.tv_maGiamGia.setText(String.valueOf(gg.getPhanTramGiam()) + "%");

            Integer discountPercentage = gg.getPhanTramGiam();
            if (discountPercentage != null) {
                double giaTien = list.get(position).getGiaTien();
                double discountedPrice = giaTien - (giaTien * discountPercentage / 100);

                // Hiển thị giá tiền gốc với gạch ngang
                String giaTienStrikethrough = String.valueOf((int) giaTien) + " vnd";
                Spannable spannable = new SpannableString(giaTienStrikethrough);
                spannable.setSpan(new StrikethroughSpan(), 0, giaTienStrikethrough.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                holder.tv_giaGoc.setText(spannable);
                holder.tv_giaDuocGiam.setText(formatMoney((int) discountedPrice) + " vnd");
                holder.tv_giaDuocGiam.setTextColor(ContextCompat.getColor(context, R.color.red));
            } else {
                holder.tv_maGiamGia.setText("Không có mã giảm giá");
                holder.tv_giaGoc.setText(formatMoney((int) list.get(position).getGiaTien()) + " vnd");
                holder.tv_giaDuocGiam.setText("");
            }
        } else {
            holder.tv_maGiamGia.setText("Không có mã giảm giá");
            holder.tv_giaGoc.setText(formatMoney((int) list.get(position).getGiaTien()) + " vnd");
            holder.tv_giaDuocGiam.setText("");
        }



        holder.img_delete_hoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogXoaHoaDon(hoaDon1);
            }


        });
    }

    private void dialogXoaHoaDon(HoaDon hoaDon) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setIcon(android.R.drawable.ic_delete);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn xóa không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                hoaDonDAO = new HoaDonDAO(context);
                int kq = hoaDonDAO.Delete(hoaDon);
                if(kq>0){
                    Toast.makeText(context, "xóa thành công", Toast.LENGTH_SHORT).show();
                    list.clear();
                    list.addAll(hoaDonDAO.getAll());
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

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_maHoaDon, tv_maMonAn, tv_maNhanVien, tv_soBan, tv_maGiamGia, tv_soLuong, tv_thoiGianTao, tv_giaDuocGiam, tv_giaGoc, tv_kieuThanhToan, tv_trangThai;
        ImageView img_edit_hoaDon, img_delete_hoaDon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_maHoaDon = itemView.findViewById(R.id.tv_maHoaDon);
            tv_maMonAn = itemView.findViewById(R.id.tv_maMonAn);
            tv_maNhanVien = itemView.findViewById(R.id.tv_maNhanVien);
            tv_soBan = itemView.findViewById(R.id.tv_soBan);
            tv_maGiamGia = itemView.findViewById(R.id.tv_maGiamGia);
            tv_soLuong = itemView.findViewById(R.id.tv_soLuong);
            tv_thoiGianTao = itemView.findViewById(R.id.tv_thoiGianTao);
            tv_giaDuocGiam = itemView.findViewById(R.id.tv_giaDuocGiam);
            tv_giaGoc = itemView.findViewById(R.id.tv_giaGoc);
            tv_kieuThanhToan = itemView.findViewById(R.id.tv_kieuThanhToan);
            tv_trangThai = itemView.findViewById(R.id.tv_trangThai);
            img_delete_hoaDon = itemView.findViewById(R.id.img_delete_hoaDon);

        }
    }
}
