package com.ph32395.khopro.Model;

public class ChiTietHoaDon {
    private int id_ChiTietHoaDon;
    private int id_HoaDon;
    private int id_MonAn;
    private int soLuong;
    private int tongTien;

    public ChiTietHoaDon(int id_ChiTietHoaDon, int id_HoaDon, int id_MonAn, int soLuong, int tongTien) {
        this.id_ChiTietHoaDon = id_ChiTietHoaDon;
        this.id_HoaDon = id_HoaDon;
        this.id_MonAn = id_MonAn;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public ChiTietHoaDon() {
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

    public int getId_MonAn() {
        return id_MonAn;
    }

    public void setId_MonAn(int id_MonAn) {
        this.id_MonAn = id_MonAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }


}
