package com.ph32395.khopro.Model;

public class HoaDon {
    private int id_HoaDon;
    private int id_MonAn;
    private int id_NhanVien;
    private int id_BanAn;
    private String ngayTao;
    private int giaTien;
    private String kieuThanhToan;
    private String trangThai;

    public int getId_HoaDon() {
        return id_HoaDon;
    }

    public void setId_HoaDon(int id_HoaDon) {
        this.id_HoaDon = id_HoaDon;
    }

    public int getId_MonAn() {
        return id_MonAn;
    }

    public void setId_MonAn(int id_MonAn) {
        this.id_MonAn = id_MonAn;
    }

    public int getId_NhanVien() {
        return id_NhanVien;
    }

    public void setId_NhanVien(int id_NhanVien) {
        this.id_NhanVien = id_NhanVien;
    }

    public int getId_BanAn() {
        return id_BanAn;
    }

    public void setId_BanAn(int id_BanAn) {
        this.id_BanAn = id_BanAn;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public String getKieuThanhToan() {
        return kieuThanhToan;
    }

    public void setKieuThanhToan(String kieuThanhToan) {
        this.kieuThanhToan = kieuThanhToan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public HoaDon(int id_HoaDon, int id_MonAn, int id_NhanVien, int id_BanAn, String ngayTao, int giaTien, String kieuThanhToan, String trangThai) {
        this.id_HoaDon = id_HoaDon;
        this.id_MonAn = id_MonAn;
        this.id_NhanVien = id_NhanVien;
        this.id_BanAn = id_BanAn;
        this.ngayTao = ngayTao;
        this.giaTien = giaTien;
        this.kieuThanhToan = kieuThanhToan;
        this.trangThai = trangThai;
    }

    public HoaDon() {
    }
}
