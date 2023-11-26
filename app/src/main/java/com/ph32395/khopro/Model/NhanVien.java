package com.ph32395.khopro.Model;

public class NhanVien {
    private int id_NhanVien;
    private String tenNhanVien;
    private String matKhau;

    public NhanVien() {
    }

    public NhanVien(int id_NhanVien, String tenNhanVien, String matKhau) {
        this.id_NhanVien = id_NhanVien;
        this.tenNhanVien = tenNhanVien;
        this.matKhau = matKhau;
    }

    public int getId_NhanVien() {
        return id_NhanVien;
    }

    public void setId_NhanVien(int id_NhanVien) {
        this.id_NhanVien = id_NhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
