package com.ph32395.khopro.Model;

public class BanAn {
    private int id_BanAn;
    private String soBan;
    private String trangThai;

    public int getId_BanAn() {
        return id_BanAn;
    }

    public void setId_BanAn(int id_BanAn) {
        this.id_BanAn = id_BanAn;
    }

    public String getSoBan() {
        return soBan;
    }

    public void setSoBan(String soBan) {
        this.soBan = soBan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public BanAn(int id_BanAn, String soBan, String trangThai) {
        this.id_BanAn = id_BanAn;
        this.soBan = soBan;
        this.trangThai = trangThai;
    }

    public BanAn() {
    }
}
