package com.ph32395.khopro.Fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import com.ph32395.khopro.R;

import java.util.Calendar;

public class ThongKeFragment extends Fragment {

    TextView tv_ngayBatDau, tv_ngayKetThuc, tv_thongDoanhThu;
    Button btn_doanhThu;
    ListView lv_doanhThu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_thong_ke, container, false);
        tv_ngayBatDau = v.findViewById(R.id.tv_ngayBatDau);
        tv_ngayKetThuc = v.findViewById(R.id.tv_ngayKetThuc);
        tv_thongDoanhThu = v.findViewById(R.id.tv_tongDoanhThu);
        btn_doanhThu = v.findViewById(R.id.btn_doanhThu);
        lv_doanhThu = v.findViewById(R.id.lv_doanhThu);

        Calendar calendar = Calendar.getInstance();
        tv_ngayBatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(
                        getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        String Ngay = "";
                        String Thang = "";
                        if (i2 < 10) {
                            Ngay = "0" + i2;
                        } else {
                            Ngay = String.valueOf(i2);
                        }

                        if ((i1 + 1) < 10) {
                            Thang = "0" + (i1 + 1);
                        } else {
                            Thang = String.valueOf(i1 + 1);
                        }
                        tv_ngayBatDau.setText(i + "/" + Thang + "/" + Ngay);
                    }
                },
                        calendar.get(calendar.YEAR),
                        calendar.get(calendar.MONTH),
                        calendar.get(calendar.DAY_OF_MONTH)
                );
                dialog.show();
            }
        });

        tv_ngayKetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(
                        getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        String Ngay = "";
                        String Thang = "";
                        if(i2 < 10){
                            Ngay = "0" + i2;
                        }else{
                            Ngay = String.valueOf(i2);
                        }

                        if((i1 + 1) < 10){
                            Thang = "0" + (i1 + 1);
                        }else{
                            Thang = String.valueOf(i1 + 1);
                        }
                        tv_ngayKetThuc.setText(i + "/" + Thang + "/" + Ngay);
                    }
                },
                        calendar.get(calendar.YEAR),
                        calendar.get(calendar.MONTH),
                        calendar.get(calendar.DAY_OF_MONTH)
                );
                dialog.show();
            }
        });


        return v;
    }
}