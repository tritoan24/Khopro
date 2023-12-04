package com.ph32395.khopro.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ph32395.khopro.Database.DbHelper;
import com.ph32395.khopro.Model.GiamGia;
import com.ph32395.khopro.Model.HoaDon;
import com.ph32395.khopro.Model.MonAn;

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
        values.put("id_NhanVien",hoaDon.getId_NhanVien());
        values.put("soBan",hoaDon.getSoBan());
        values.put("ngayGio",hoaDon.getNgayGio());
        values.put("kieuThanhToan",hoaDon.getKieuThanhToan());
        values.put("tongTien",hoaDon.getTongTien());
        return db.insert("HoaDon",null,values);
    }
    public  int Update(HoaDon hoaDon){
        ContentValues values = new ContentValues();
        values.put("id_HoaDon", hoaDon.getId_HoaDon() );
        values.put("id_NhanVien",hoaDon.getId_NhanVien());
        values.put("soBan",hoaDon.getSoBan());
        values.put("ngayGio",hoaDon.getNgayGio());
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

    @SuppressLint("Range")
    public List<HoaDon> getData(String sql , String...selectionArgs){
        List<HoaDon> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            HoaDon hd = new HoaDon();
            // Check if id_DanhMuc is not null before parsing
            hd.setId_NhanVien(c.getString(c.getColumnIndex("id_NhanVien")));


            String baan = c.getString(c.getColumnIndex("soBan"));
            hd.setSoBan(baan!=null?Integer.parseInt(baan):0);

            // Check if id_GiamGia is not null before parsing

            hd.setNgayGio(c.getString(c.getColumnIndex("ngayGio")));


            // Check if giaTien is not null before parsing
            String tongTien = c.getString(c.getColumnIndex("tongTien"));
            hd.setTongTien(tongTien != null ? Integer.parseInt((tongTien)) : (int) 0.0);
            hd.setKieuThanhToan(c.getString(c.getColumnIndex("kieuThanhToan")));
            list.add(hd);
        }
        return list;
    }


}
