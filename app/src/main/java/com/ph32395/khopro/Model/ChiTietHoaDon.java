package com.ph32395.khopro.Model;

public class ChiTietHoaDon {
    private int id_ChiTietHoaDon;
    private int id_HoaDon;
    private String tenMonAn;
    private int soLuong;
    private int giaTien;
    private int tongTien;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int id_ChiTietHoaDon, int id_HoaDon, String tenMonAn, int soLuong, int giaTien, int tongTien) {
        this.id_ChiTietHoaDon = id_ChiTietHoaDon;
        this.id_HoaDon = id_HoaDon;
        this.tenMonAn = tenMonAn;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.tongTien = tongTien;
    }

    public int getId_ChiTietHoaDon() {
        return id_ChiTietHoaDon;
    }

    public void setId_ChiTietHoaDon(int id_ChiTietHoaDon) {
        this.id_ChiTietHoaDon = id_ChiTietHoaDon;
    }

    public int getId_HoaDon() {
        return id_HoaDon;
    }

    public void setId_HoaDon(int id_HoaDon) {
        this.id_HoaDon = id_HoaDon;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
}
