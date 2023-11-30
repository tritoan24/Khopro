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

import com.ph32395.khopro.DAO.BanAnDAO;
import com.ph32395.khopro.DAO.GiamGiaDAO;
import com.ph32395.khopro.DAO.HoaDonDAO;
import com.ph32395.khopro.DAO.NhanVienDAO;
import com.ph32395.khopro.Fragment.QLHoaDonFragment;
import com.ph32395.khopro.Model.BanAn;
import com.ph32395.khopro.Model.GiamGia;
import com.ph32395.khopro.Model.HoaDon;
import com.ph32395.khopro.Model.NhanVien;
import com.ph32395.khopro.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class HoaDon_Adapter extends RecyclerView.Adapter<HoaDon_Adapter.ViewHolder> {
    Context context;
    private ArrayList<HoaDon> list;

    HoaDonDAO hoaDonDAO;
    HoaDon_Adapter adapter;

    GiamGiaDAO giamGiaDAO;
    NhanVienDAO nhanVienDAO;
    BanAnDAO banAnDAO;


    QLHoaDonFragment hoaDonFragment;

    public HoaDon_Adapter(Context context, ArrayList<HoaDon> list) {
        this.context = context;
        this.list = list;
        this.hoaDonFragment = hoaDonFragment;
        hoaDonDAO = new HoaDonDAO(context);
        adapter = this;
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

        nhanVienDAO = new NhanVienDAO(context);
        NhanVien nv = nhanVienDAO.getID(String.valueOf(hoaDon1.getId_NhanVien()));
        holder.tvtennhanvien.setText(nv.getHoTen());

        banAnDAO = new BanAnDAO(context);
        BanAn ba = banAnDAO.getBanAnByID(hoaDon1.getId_BanAn());
        holder.tv_soBan.setText(String.valueOf(ba.getSoBan()+""));

        giamGiaDAO = new GiamGiaDAO(context);
        GiamGia gg = giamGiaDAO.getID(String.valueOf(hoaDon1.getId_GiamGia()));
        holder.tvphantramgiamgia.setText(gg.getPhanTramGiam()+"%");

        holder.tv_soLuong.setText(String.valueOf(hoaDon1.getSoLuong()));
        holder.tv_thoiGianTao.setText(hoaDon1.getNgayGio());
        holder.tv_kieuThanhToan.setText(hoaDon1.getKieuThanhToan());
        holder.tvtongtien.setText(String.valueOf( hoaDon1.getTongTien()));


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
        TextView tv_maHoaDon, tvtennhanvien, tv_soBan, tvphantramgiamgia, tv_soLuong, tv_thoiGianTao, tv_giaDuocGiam, tvtongtien, tv_kieuThanhToan, tv_trangThai;
        ImageView img_edit_hoaDon, img_delete_hoaDon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_maHoaDon = itemView.findViewById(R.id.tv_maHoaDon);
            tvtennhanvien = itemView.findViewById(R.id.tv_maNhanVien);
            tv_soBan = itemView.findViewById(R.id.tv_soBan);
            tvphantramgiamgia = itemView.findViewById(R.id.tv_maGiamGia);
            tv_soLuong = itemView.findViewById(R.id.tv_soLuong);
            tv_thoiGianTao = itemView.findViewById(R.id.tv_thoiGianTao);
            tvtongtien = itemView.findViewById(R.id.tv_giaGoc);
            tv_kieuThanhToan = itemView.findViewById(R.id.tv_kieuThanhToan);
            img_delete_hoaDon = itemView.findViewById(R.id.img_delete_hoaDon);

        }
    }
}
