package com.ph32395.khopro.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ph32395.khopro.Database.DbHelper;
import com.ph32395.khopro.Model.GiamGia;
import com.ph32395.khopro.Model.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class HoaDonDAO {
    private com.ph32395.khopro.Database.DbHelper DbHelper;
    private SQLiteDatabase db;

    public HoaDonDAO(Context context){
        DbHelper = new DbHelper(context);
        db = DbHelper.getWritableDatabase();
    }
    public long Insert(HoaDon hoaDon){
        ContentValues values = new ContentValues();
        values.put("id_HoaDon", hoaDon.getId_HoaDon() );
        values.put("id_MonAn", hoaDon.getId_MonAn());
        values.put("id_NhanVien",hoaDon.getId_NhanVien());
        values.put("id_BanAn",hoaDon.getId_BanAn());
        values.put("id_GiamGia",hoaDon.getId_GiamGia());
        values.put("soLuong",hoaDon.getSoLuong());
        values.put("ngayGio",hoaDon.getNgayGio());
        values.put("giaTien",hoaDon.getGiaTien());
        values.put("kieuThanhToan",hoaDon.getKieuThanhToan());
        values.put("tongTien",hoaDon.getTongTien());
        return db.insert("HoaDon",null,values);
    }
    public  int Update(HoaDon hoaDon){
        ContentValues values = new ContentValues();
        values.put("id_HoaDon", hoaDon.getId_HoaDon() );
        values.put("id_MonAn", hoaDon.getId_MonAn());
        values.put("id_NhanVien",hoaDon.getId_NhanVien());
        values.put("id_BanAn",hoaDon.getId_BanAn());
        values.put("id_GiamGia",hoaDon.getId_GiamGia());
        values.put("soLuong",hoaDon.getSoLuong());
        values.put("ngayGio",hoaDon.getNgayGio());
        values.put("giaTien",hoaDon.getGiaTien());
        values.put("kieuThanhToan",hoaDon.getKieuThanhToan());
        values.put("tongTien",hoaDon.getTongTien());
        String[] dk = new String[]{String.valueOf(hoaDon.getId_HoaDon())};
        return db.update("HoaDon",values,"id_HoaDon=?",dk);
    }
    public  int Delete(HoaDon hoaDon){
        String[] dk = new String[]{String.valueOf(hoaDon.getId_HoaDon())};
        return db.delete("HoaDon","id_HoaDon=?",dk);

    }
    public List<HoaDon> getAll(){
        String sql = "SELECT * FROM HoaDon";
        return getData(sql);
    }
    public HoaDon getID(String id){
        String sql = "SELECT * FROM HoaDon WHERE id_HoaDon=?";
        List<HoaDon> list = getData(sql,id);
        return list.get(0);
    }
    public List<HoaDon> getData(String sql , String...selectionArgs){
        List<HoaDon> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        if(c!=null && c.getCount()>0){
            c.moveToFirst();
            do {
                int id_HoaDon = c.getInt(0);
                int id_MonAn = c.getInt(1);
                int id_NhanVien = c.getInt(2);
                int id_banAn = c.getInt(3);
                int id_GiamGia = c.getInt(4);
                int soLuong = c.getInt(5);
                String ngayGio = c.getString(6);
                int giaTien = c.getInt(7);
                String kieuThanhToan = c.getString(8);
                int tongTien = c.getInt(9);
                HoaDon hoaDon = new HoaDon();
                hoaDon.setId_HoaDon(id_HoaDon);
                hoaDon.setId_NhanVien(id_NhanVien);
                hoaDon.setId_BanAn(id_banAn);
                hoaDon.setId_GiamGia(id_GiamGia);
                hoaDon.setSoLuong(soLuong);
                hoaDon.setNgayGio(ngayGio);
                hoaDon.setGiaTien(giaTien);
                hoaDon.setKieuThanhToan(kieuThanhToan);
                hoaDon.setTongTien(tongTien);
                hoaDon.setId_MonAn(id_MonAn);
                list.add(hoaDon);
            }while (c.moveToNext());
        }
        return list;
    }
}
