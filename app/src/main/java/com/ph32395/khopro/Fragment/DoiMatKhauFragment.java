package com.ph32395.khopro.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.ph32395.khopro.DAO.NhanVienDAO;
import com.ph32395.khopro.R;

public class DoiMatKhauFragment extends Fragment {

    EditText ed_manguoidung_changePass, ed_username_changePass, ed_mkCu, ed_mkMoi;
    Button btn_cancel_changePass, btn_confirm_changPass;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_doi_mat_khau, container, false);
        ed_manguoidung_changePass = v.findViewById(R.id.ed_manguoidung_changePass);
        ed_username_changePass = v.findViewById(R.id.ed_username_changePass);
        ed_mkCu = v.findViewById(R.id.ed_passwordChange);
        ed_mkMoi = v.findViewById(R.id.ed_passwordNew);
        btn_confirm_changPass = v.findViewById(R.id.btn_confirm_changPass);
        btn_cancel_changePass = v.findViewById(R.id.btn_cancel_changePass);

        btn_cancel_changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed_username_changePass.setText("");
                ed_manguoidung_changePass.setText("");
                ed_mkMoi.setText("");
                ed_mkCu.setText("");
            }
        });

        btn_confirm_changPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldPass = ed_mkCu.getText().toString();
                String newPass = ed_mkMoi.getText().toString();

                SharedPreferences sharedPreferences = getContext().getSharedPreferences("User_File" , getContext().MODE_PRIVATE);
                String user = sharedPreferences.getString("Username", "");
                String pass = sharedPreferences.getString("Password", "");
                NhanVienDAO nhanVienDAO = new NhanVienDAO(getContext());
            }
        });
        return v;
    }
}