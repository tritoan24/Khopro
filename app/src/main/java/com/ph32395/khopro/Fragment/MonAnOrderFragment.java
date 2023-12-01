package com.ph32395.khopro.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ph32395.khopro.Adapter.MonAnOrder_Adapter;
import com.ph32395.khopro.Adapter.MonAn_Adapter;
import com.ph32395.khopro.DAO.MonAnDAO;
import com.ph32395.khopro.Model.MonAn;
import com.ph32395.khopro.R;

import java.util.ArrayList;
import java.util.List;

public class MonAnOrderFragment extends Fragment {
    MonAnDAO monAnDAO;
    ArrayList<MonAn> list;
    MonAnOrder_Adapter monAnOrder_adapter;
    RecyclerView rc_monAnOrder;
    Button checkBill;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.order_monan, container, false);

        rc_monAnOrder = v.findViewById(R.id.rc_monAnOrder);
        checkBill = v.findViewById(R.id.btn_checkBill);

        monAnDAO = new MonAnDAO(getContext());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rc_monAnOrder.setLayoutManager(layoutManager);

        list = (ArrayList<MonAn>) monAnDAO.getAll();
        monAnOrder_adapter = new MonAnOrder_Adapter(getActivity(), list);
        rc_monAnOrder.setAdapter(monAnOrder_adapter);

        int categoryId = getArguments().getInt("CategoryId", -1);

        if (categoryId != -1) {
            // Nếu có id danh mục, thực hiện truy vấn database để lấy danh sách món ăn
            List<MonAn> danhSachMonAn = monAnDAO.getMonAnByCategoryId(categoryId);

            // Cập nhật danh sách món ăn và thông báo cho Adapter
            list.clear();
            list.addAll(danhSachMonAn);
            monAnOrder_adapter.notifyDataSetChanged();
            for (MonAn monAn : danhSachMonAn) {
                Log.d("DanhSachMonAnFragment", "MonAn: " + monAn.getTenMonAn());
            }
        }

        return v;
    }

    @Override
    public void onDestroy() {
        // Giải phóng đối tượng MonAnDAO khi Fragment bị hủy
        if (monAnDAO != null) {
            monAnDAO.close();
        }
        super.onDestroy();
    }

}

