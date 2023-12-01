package com.ph32395.khopro.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.ph32395.khopro.Adapter.BanAnOrderAdapter;
import com.ph32395.khopro.DAO.BanAnDAO;
import com.ph32395.khopro.Model.BanAn;
import com.ph32395.khopro.Model.OnBanAnClickListener;
import com.ph32395.khopro.R;
import java.util.ArrayList;

public class BanAnOrderFragment extends Fragment implements OnBanAnClickListener{
    BanAnDAO dao;
    GridView gridView;
    ArrayList<BanAn> list;
    BanAnOrderAdapter adapter;
    TextView txtMangVe;
    private OnBanAnClickListener onBanAnClickListener;

    public void setOnBanAnClickListener(OnBanAnClickListener listener) {
        this.onBanAnClickListener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ban_an_order, container, false);
        dao = new BanAnDAO(getContext());
        gridView = v.findViewById(R.id.gridView);

        list = (ArrayList<BanAn>) dao.getAll();
        adapter = new BanAnOrderAdapter(getActivity(), list);
        adapter.setOnBanAnClickListener(this);


        gridView.setAdapter(adapter);

        txtMangVe = v.findViewById(R.id.txtMangVe);
        txtMangVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soBan = 0;
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Tạo một Fragment mới và chuyển dữ liệu số bàn qua
                HomeFragment anotherFragment = new HomeFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("SoBan", soBan);
                anotherFragment.setArguments(bundle);

                fragmentTransaction.replace(R.id.flContent, anotherFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return v;
    }
    @Override
    public void onBanAnClick(int soBan) {
        Log.d("BanAnOrderFragment", "Clicked on BanAn: " + soBan);

        // Xử lý khi người dùng nhấn vào item, ví dụ: chuyển sang Fragment khác
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Tạo một Fragment mới và chuyển dữ liệu số bàn qua
        HomeFragment anotherFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("SoBan", soBan);
        anotherFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.flContent, anotherFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
