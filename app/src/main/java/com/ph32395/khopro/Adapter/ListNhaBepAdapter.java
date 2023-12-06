package com.ph32395.khopro.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ph32395.khopro.Model.ChiTietHoaDon;
import com.ph32395.khopro.R;

import java.util.List;

public class ListNhaBepAdapter extends BaseAdapter {
    private Context context;
    private List<ChiTietHoaDon> listHoaDonChiTiet;

    public ListNhaBepAdapter(Context context, List<ChiTietHoaDon> listHoaDonChiTiet) {
        this.context = context;
        this.listHoaDonChiTiet = listHoaDonChiTiet;
    }

    @Override
    public int getCount() {
        return listHoaDonChiTiet.size();
    }

    @Override
    public Object getItem(int position) {
        return listHoaDonChiTiet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_hoadon_nhabep, parent, false);

            viewHolder = new ListNhaBepAdapter.ViewHolder();
            viewHolder.txtSoTT = convertView.findViewById(R.id.tv_sott_nhaBep);
            viewHolder.txtTenMonAn = convertView.findViewById(R.id.tv_tenmonan_nhabep);
            viewHolder.txtSoLuong = convertView.findViewById(R.id.tv_soLuong_nhabep);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ChiTietHoaDon hoaDonChiTiet = listHoaDonChiTiet.get(position);
        int stt = position + 1;
        viewHolder.txtSoTT.setText(stt+"");
        viewHolder.txtTenMonAn.setText(hoaDonChiTiet.getTenMonAn());
        viewHolder.txtSoLuong.setText(String.valueOf(hoaDonChiTiet.getSoLuong()));

        return convertView;
    }

    static class ViewHolder {
        TextView txtSoTT;
        TextView txtTenMonAn;
        TextView txtSoLuong;
    }
}
