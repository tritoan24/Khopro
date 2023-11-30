package com.ph32395.khopro.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ph32395.khopro.Database.DbHelper;
import com.ph32395.khopro.Model.GiamGia;
import com.ph32395.khopro.Model.MonAn;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MonAnDAO{
    private SQLiteDatabase db;
    public MonAnDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public void close() {
        if (db != null && db.isOpen()) {
            db.close();
        }
    }

    public long Insert(MonAn monAn){
        try {
            ContentValues values = new ContentValues();
            values.put("tenMonAn", monAn.getTenMonAn());
            values.put("id_DanhMuc", monAn.getId_DanhMuc());
            values.put("id_GiamGia", monAn.getId_GiamGia());
            values.put("giaTien", monAn.getGiaTien());
            return db.insert("MonAn", null, values);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
    public int Update(MonAn monAn) {
        try {
            ContentValues values = new ContentValues();
            values.put("tenMonAn", monAn.getTenMonAn());
            values.put("id_DanhMuc", monAn.getId_DanhMuc());
            values.put("id_GiamGia", monAn.getId_GiamGia());
            values.put("giaTien", monAn.getGiaTien());

            return db.update("MonAn", values, "id_MonAn=?", new String[]{String.valueOf(monAn.getId_MonAn())});
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }



    public  int Delete(MonAn monAn){
        try{
        return db.delete("MonAn","id_MonAn=?",new String[]{String.valueOf(monAn.getId_MonAn())});
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }


    @SuppressLint("Range")
    public List<MonAn> getData(String sql , String...selectionArgs){
        List<MonAn> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            MonAn monAn = new MonAn();
            monAn.setId_MonAn(Integer.parseInt(c.getString(c.getColumnIndex("id_MonAn"))));
            monAn.setTenMonAn(c.getString(c.getColumnIndex("tenMonAn")));
            // Check if id_DanhMuc is not null before parsing
            String idDanhMuc = c.getString(c.getColumnIndex("id_DanhMuc"));
            monAn.setId_DanhMuc(idDanhMuc != null ? Integer.parseInt(idDanhMuc) : 0);

            // Check if id_GiamGia is not null before parsing
            String idGiamGia = c.getString(c.getColumnIndex("id_GiamGia"));
            monAn.setId_GiamGia(idGiamGia != null ? Integer.parseInt(idGiamGia) : 0);

            // Check if giaTien is not null before parsing
            String giaTien = c.getString(c.getColumnIndex("giaTien"));
            monAn.setGiaTien(giaTien != null ? Double.parseDouble(giaTien) : 0.0);

            list.add(monAn);
        }
        return list;
    }
    public List<MonAn>getAll(){
        String sql = "Select * from MonAn";
        return getData(sql);
    }
    public MonAn getID(String id){
        String sql = "SELECT * FROM MonAn WHERE id_MonAn=?";
        List<MonAn> list = getData(sql,id);
        return list.get(0);
    }


}
