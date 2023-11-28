package com.ph32395.khopro.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ph32395.khopro.Database.DbHelper;
import com.ph32395.khopro.Model.BanAn;
import com.ph32395.khopro.Model.GiamGia;
import com.ph32395.khopro.Model.MonAn;

import java.util.ArrayList;
import java.util.List;

public class MonAnDAO{
    private com.ph32395.khopro.Database.DbHelper DbHelper;
    private SQLiteDatabase db;
    public MonAnDAO(Context context){
        DbHelper = new DbHelper(context);
        db = DbHelper.getWritableDatabase();
    }

    public long Insert(MonAn monAn){
        ContentValues values = new ContentValues();
        values.put("tenMonAn", monAn.getTenMonAn());
        values.put("id_DanhMuc",monAn.getId_DanhMuc());
        values.put("id_GiamGia",monAn.getId_GiamGia());
        values.put("giaTien",monAn.getGiaTien());
        return db.insert("MonAn",null,values);
    }
    public  int Update(MonAn monAn){
        ContentValues values = new ContentValues();
        values.put("tenMonAn", monAn.getTenMonAn());
        values.put("id_DanhMuc",monAn.getId_DanhMuc());
        values.put("id_GiamGia",monAn.getId_GiamGia());
        values.put("giaTien",monAn.getGiaTien());
        String[] dk = new String[]{String.valueOf(monAn.getId_MonAn())};
        return db.update("MonAn",values,"id_MonAn=?",dk);
    }
    public  int Delete(MonAn monAn){
        String[] dk = new String[]{String.valueOf(monAn.getId_MonAn())};
        return db.delete("MonAn","id_MonAn=?",dk);

    }
    public List<MonAn> getAll(){
        String sql = "Select * from BanAn";
        return getData(sql);
    }

    public MonAn getID(String id){
        String sql = "SELECT * FROM MonAn WHERE id_MonAn=?";
        List<MonAn> list = getData(sql,id);
        return list.get(0);
    }
    public List<MonAn> getData(String sql , String...selectionArgs){
        List<MonAn> list = new ArrayList<>();
        try {
            Cursor c = db.rawQuery(sql, selectionArgs);
            while (c.moveToNext()){
                MonAn obj = new MonAn();
                obj.setId_MonAn(Integer.parseInt(String.valueOf(c.getColumnIndex("id_MonAn"))));
                obj.setTenMonAn(String.valueOf(c.getColumnIndex("tenMonAn")));
                obj.setId_DanhMuc(Integer.parseInt(String.valueOf(c.getColumnIndex("id_DanhMuc"))));
                obj.setId_GiamGia(Integer.parseInt(String.valueOf(c.getColumnIndex("id_GiamGia"))));
                obj.setGiaTien(c.getColumnIndex("giaTien"));
                list.add(obj);
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
