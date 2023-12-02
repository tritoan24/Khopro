package com.ph32395.khopro.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ph32395.khopro.R;

public class XacNhanOrderFragment extends Fragment {

    ImageView img_back_cfOrder;
    TextView tv_soBan_cfOrder, tv_thanhTien, tv_giamGia_cfOrder, tv_truTien, tv_tongTien;
    ListView lv_confirm_order;
    Button btn_confirm_order,btn_confirm_order_print;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_xac_nhan_order, container, false);
        img_back_cfOrder = v.findViewById(R.id.img_back_cfOrder);
        tv_soBan_cfOrder = v.findViewById(R.id.tv_soBan_cfOrder);
        tv_thanhTien = v.findViewById(R.id.tv_thanhTien);
        tv_giamGia_cfOrder = v.findViewById(R.id.tv_giamGia_cfOrder);
        tv_truTien = v.findViewById(R.id.tv_truTien);
        tv_tongTien = v.findViewById(R.id.tv_tongTien);
        btn_confirm_order = v.findViewById(R.id.btn_confirm_order);
        btn_confirm_order_print = v.findViewById(R.id.btn_confirm_order_print);

        lv_confirm_order = v.findViewById(R.id.lv_confirm_order);

        return v;
    }
}