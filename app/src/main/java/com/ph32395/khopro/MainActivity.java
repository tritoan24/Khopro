package com.ph32395.khopro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.ph32395.khopro.Fragment.DoiMatKhauFragment;
import com.ph32395.khopro.Fragment.QLBanAnFragment;
import com.ph32395.khopro.Fragment.QLDanhMucFragment;
import com.ph32395.khopro.Fragment.QLHoaDonFragment;
import com.ph32395.khopro.Fragment.QLMaGiamGiaFragment;
import com.ph32395.khopro.Fragment.QLMonanFragment;
import com.ph32395.khopro.Fragment.QLNhanVienFragment;
import com.ph32395.khopro.Fragment.ThongKeFragment;

public class MainActivity extends AppCompatActivity {

    private static final int NAV_QLMONAN = R.id.nav_QLMonAn;
    private static final int NAV_QLDANHMUC = R.id.nav_QLDanhMuc;
    private static final int NAV_QLBANAN = R.id.nav_QLBanAn;
    private static final int NAV_QLMAGIAMGIA = R.id.nav_QLMaGiamGia;
    private static final int NAV_QLHOADON = R.id.nav_QLHoaDon;
    private static final int NAV_QLNHANVIEN = R.id.nav_QLNhanVien;
    private static final int NAV_THONGKE = R.id.nav_ThongKe;
    private static final int NAV_DOIMATKHAU = R.id.nav_DoiMatKhau;
    private static final int NAV_DANGXUAT = R.id.nav_DangXuat;


    DrawerLayout drawer;
    Toolbar toolbar;
    View mHeaderView;
    TextView edUser;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        drawer = findViewById(R.id.my_drawer_layout);

        toolbar = findViewById(R.id.toolbar1);


        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }


        NavigationView nv = findViewById(R.id.nvView);

        mHeaderView = nv.getHeaderView(0);
//        edUser = mHeaderView.findViewById(R.id.txtUser);
//        Intent i = getIntent();
//        String user = i.getStringExtra("user");
        //viết hàm để lấy tên

//        ttDao = new ThuThuDAO(this);
//        ThuThu thuThu = ttDao.getID(user);
//        String username = thuThu.getHoTen();
//        edUser.setText("Chào mừng "+username+" đến với LibraPro!");

        // Đặt Fragment PhieuMuon là màn hình mặc định
        setTitle("Quản Lý Phiếu Mượn");
        Fragment fragment = new QLMonanFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flContent, fragment); // R.id.flContent là ID của layout container cho fragment
        fragmentTransaction.commit();


//        sharedPreferences = getSharedPreferences("THONGTIN", MODE_PRIVATE);
//        String loaiTaiKhoan = sharedPreferences.getString("loaitaikhoan", "");
//
//        if ("Admin".equals(loaiTaiKhoan)) {
//            Toast.makeText(this, "Bạn Đang Đăng Nhập Trên Tài Khoản ADMIN", Toast.LENGTH_SHORT).show();
//        } else {
//            nv.getMenu().findItem(NAV_DOANHTHU).setVisible(false);
//            nv.getMenu().findItem(NAV_TOP10).setVisible(false);
//            nv.getMenu().findItem(NAV_THEMTV).setVisible(false);
//            Toast.makeText(this, "Bạn Đang Đăng Nhập Trên Tài Khoản Thủ Thư", Toast.LENGTH_SHORT).show();
//
//        }

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                String title = "";


                if (item.getItemId() == NAV_QLMONAN) {
                    setTitle("Quản Lý Món Ăn");
                    fragment = new QLMonanFragment();
                } else if (item.getItemId() == NAV_QLDANHMUC) {
                    setTitle("Quản Lý Danh Mục");
                    fragment = new QLDanhMucFragment();
                } else if (item.getItemId() == NAV_QLBANAN) {
                    setTitle("Quản Lý Bàn Ăn");
                    fragment = new QLBanAnFragment();
                } else if (item.getItemId() == NAV_QLMAGIAMGIA) {
                    setTitle("Quản Lý Mã Giảm Giá");
                    fragment = new QLMaGiamGiaFragment();
                } else if (item.getItemId() == NAV_QLHOADON) {
                    setTitle("Quản Lý Hóa Đơn");
                    fragment = new QLHoaDonFragment();
                } else if (item.getItemId() == NAV_QLNHANVIEN) {
                    setTitle("Quản Lý Nhân Viên");
                    fragment = new QLNhanVienFragment();
                } else if (item.getItemId() == NAV_THONGKE) {
                    setTitle("Thống Kê");
                    fragment = new ThongKeFragment();
                } else if (item.getItemId() == NAV_DOIMATKHAU) {
                    setTitle("Đổi Mật Khẩu");
                    fragment = new DoiMatKhauFragment();
                } else if (item.getItemId() == NAV_DANGXUAT) {
                    setTitle("Đăng Xuất");
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finish();
                }

                if (fragment != null) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.flContent, fragment); // R.id.fragment_container là ID của layout container cho fragment
                    fragmentTransaction.commit();
                }

                drawer.closeDrawers();
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home)
            drawer.openDrawer(GravityCompat.START);
        return super.onOptionsItemSelected(item);
    }
}