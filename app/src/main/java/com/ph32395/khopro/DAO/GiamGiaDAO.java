package com.ph32395.khopro.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ph32395.khopro.Database.DbHelper;
import com.ph32395.khopro.Model.GiamGia;

import java.util.ArrayList;
import java.util.List;

public class GiamGiaDAO {
    private DbHelper DbHelper;
    private SQLiteDatabase db;

    public GiamGiaDAO(Context context){
        DbHelper = new DbHelper(context);
        db = DbHelper.getWritableDatabase();
    }

    public long Insert(GiamGia giamGia){
        ContentValues values = new ContentValues();
        values.put("maGiamgia", giamGia.getMaGiamGia() );
        values.put("phanTramGiam",giamGia.getPhanTramGiam());
        return db.insert("GiamGia",null,values);
    }
    public  int Update(GiamGia giamGia){
        ContentValues values = new ContentValues();
        values.put("maGiamgia", giamGia.getMaGiamGia() );
        values.put("phanTramGiam",giamGia.getPhanTramGiam());
        String[] dk = new String[]{String.valueOf(giamGia.getId_GiamGia())};
        return db.update("GiamGia",values,"id_GiamGia=?",dk);
    }
    public  int Delete(GiamGia giamGia){
        String[] dk = new String[]{String.valueOf(giamGia.getId_GiamGia())};
        return db.delete("GiamGia","id_GiamGia=?",dk);

    }

    public List<GiamGia> getAll(){
        String sql = "SELECT * FROM GiamGia";
        return getData(sql);
    }

    public GiamGia getID(String id){
        String sql = "SELECT * FROM GiamGia WHERE id_GiamGia=?";
        List<GiamGia> list = getData(sql,id);
        return list.get(0);
    }
    public List<GiamGia> getData(String sql , String...selectionArgs){
        List<GiamGia> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        if(c!=null && c.getCount()>0){
            c.moveToFirst();
            do {
                int id_GiamGia = c.getInt(0);
                String maGiamGia = c.getString(1);
                int PhanTramGiam = c.getInt(2);
                GiamGia giamGia = new GiamGia();
                giamGia.setId_GiamGia(id_GiamGia);
                giamGia.setMaGiamGia(maGiamGia);
                giamGia.setPhanTramGiam(PhanTramGiam);
                list.add(giamGia);
            }while (c.moveToNext());
        }
        return list;
    }
}
