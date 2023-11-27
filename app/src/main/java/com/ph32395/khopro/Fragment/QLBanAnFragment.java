package com.ph32395.khopro.Fragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.ph32395.khopro.Adapter.BanAn_Adapter;
import com.ph32395.khopro.DAO.BanAnDAO;
import com.ph32395.khopro.Model.BanAn;
import com.ph32395.khopro.R;

import java.util.ArrayList;

public class QLBanAnFragment extends Fragment {

    ImageView img_addBanAn;
    RecyclerView rc_qlba;
    BanAnDAO banAnDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_q_l_ban_an, container, false);
        img_addBanAn = v.findViewById(R.id.img_add_banAn);
        rc_qlba = v.findViewById(R.id.rc_quanLyBanAn);
        banAnDAO = new BanAnDAO(getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rc_qlba.setLayoutManager(layoutManager);
        ArrayList<BanAn> list = banAnDAO.getListBanAn();
        BanAn_Adapter adapter = new BanAn_Adapter(getContext(),list);
        rc_qlba.setAdapter(adapter);
        img_addBanAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogAddBanAn();
            }
        });
        return v;
    }

    private void dialogAddBanAn() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.add_banan, null);
        builder.setView(v);
        Dialog dialog = builder.create();
        dialog.show();

        EditText ed_banAn = v.findViewById(R.id.ed_tenBanAn);
        Button btn_them = v.findViewById(R.id.btn_themBanAn);
        Button btn_huy = v.findViewById(R.id.btn_huyThemBanAn);

    }
}