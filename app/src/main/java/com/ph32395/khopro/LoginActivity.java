package com.ph32395.khopro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ph32395.khopro.DAO.NhanVienDAO;
import com.ph32395.khopro.Fragment.HomeFragment;
import com.ph32395.khopro.Fragment.ProfileFragment;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText edmaNhanVien,edmatKhau;
    String strmanv, strPass;
    NhanVienDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btndangnhap_login);
        edmaNhanVien = findViewById(R.id.ed_manguoidung_login);
        edmatKhau = findViewById(R.id.ed_password_login);
        dao = new NhanVienDAO(this);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
            }
        });


    }
    public void checkLogin() {
        strmanv = edmaNhanVien.getText().toString();
        strPass = edmatKhau.getText().toString();

        if (strmanv.isEmpty() || strPass.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Mã người dùng và mật khẩu không được bỏ trống", Toast.LENGTH_SHORT).show();
        } else {
            if (dao.checkLogin(strmanv, strPass) > 0) {
                Toast.makeText(getApplicationContext(), "Login thành công", Toast.LENGTH_SHORT).show();
//                rememberUser(srtUser,strPass,ckRemenberPass.isChecked());
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
//                i.putExtra("user",srtUser);
                saveMmaToSharedPreferences(strmanv);
                startActivity(i);
                finish();
            } else {
                Toast.makeText(this, "Tên đăng nhập và mật khẩu không đúng", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void saveMmaToSharedPreferences(String mma) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("mma", mma);
        editor.apply();
    }


}