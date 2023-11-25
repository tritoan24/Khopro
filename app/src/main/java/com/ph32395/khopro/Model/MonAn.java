package com.ph32395.khopro.Model;

public class MonAn {
    private int id_MonAn;
    private String tenMonAn;
    private int id_DanhMuc;
    private int giaTien;

    public MonAn(int id_MonAn, String tenMonAn, int id_DanhMuc, int giaTien) {
        this.id_MonAn = id_MonAn;
        this.tenMonAn = tenMonAn;
        this.id_DanhMuc = id_DanhMuc;
        this.giaTien = giaTien;
    }

    public MonAn() {
    }

    public int getId_MonAn() {
        return id_MonAn;
    }

    public void setId_MonAn(int id_MonAn) {
        this.id_MonAn = id_MonAn;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public int getId_DanhMuc() {
        return id_DanhMuc;
    }

    public void setId_DanhMuc(int id_DanhMuc) {
        this.id_DanhMuc = id_DanhMuc;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }
}
