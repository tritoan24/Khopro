package com.ph32395.khopro.Model;

public class GiamGia {
    private int id_GiamGia;
    private String maGiamGia;
    private int phanTramGiam;

    public GiamGia() {
    }

    public GiamGia(int id_GiamGia, String maGiamGia, int phanTramGiam) {
        this.id_GiamGia = id_GiamGia;
        this.maGiamGia = maGiamGia;
        this.phanTramGiam = phanTramGiam;
    }

    public int getId_GiamGia() {
        return id_GiamGia;
    }

    public void setId_GiamGia(int id_GiamGia) {
        this.id_GiamGia = id_GiamGia;
    }

    public String getMaGiamGia() {
        return maGiamGia;
    }

    public void setMaGiamGia(String maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }
}
