package com.ph32395.khopro.Model;

import java.security.Timestamp;
import java.util.Date;

public class HoaDon {
    private int id_HoaDon;
    private int id_MonAn;
    private int id_NhanVien;
    private Integer id_BanAn; // Sử dụng Integer để cho phép giá trị null
    private Integer id_GiamGia;
    private int soLuong;
    private String ngayGio;
    private int giaTien;
    private String kieuThanhToan;
    private double tongTien;

    public HoaDon() {
    }

    public HoaDon(int id_HoaDon, int id_MonAn, int id_NhanVien, Integer id_BanAn, Integer id_GiamGia, int soLuong, String ngayGio, int giaTien, String kieuThanhToan, double tongTien) {
        this.id_HoaDon = id_HoaDon;
        this.id_MonAn = id_MonAn;
        this.id_NhanVien = id_NhanVien;
        this.id_BanAn = id_BanAn;
        this.id_GiamGia = id_GiamGia;
        this.soLuong = soLuong;
        this.ngayGio = ngayGio;
        this.giaTien = giaTien;
        this.kieuThanhToan = kieuThanhToan;
        this.tongTien = tongTien;
    }

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

    public Integer getId_BanAn() {
        return id_BanAn;
    }

    public void setId_BanAn(Integer id_BanAn) {
        this.id_BanAn = id_BanAn;
    }

    public Integer getId_GiamGia() {
        return id_GiamGia;
    }

    public void setId_GiamGia(Integer id_GiamGia) {
        this.id_GiamGia = id_GiamGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayGio() {
        return ngayGio;
    }

    public void setNgayGio(String ngayGio) {
        this.ngayGio = ngayGio;
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

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
}
