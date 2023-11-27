package com.ph32395.khopro.Model;

public class NhanVien {
    private String maNhanVien;
    private String hoTen;
    private String matKhau;
    private String loaiTaiKhoan;

    public NhanVien() {
    }

    public NhanVien(String maNhanVien, String hoTen, String matKhau, String loaiTaiKhoan) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
        this.loaiTaiKhoan = loaiTaiKhoan;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getLoaiTaiKhoan() {
        return loaiTaiKhoan;
    }

    public void setLoaiTaiKhoan(String loaiTaiKhoan) {
        this.loaiTaiKhoan = loaiTaiKhoan;
    }
}