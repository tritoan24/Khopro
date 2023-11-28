package com.ph32395.khopro.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ph32395.khopro.Database.DbHelper;
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
        String sql = "SELECT MonAn.id_MonAn , DanhMuc.tenDanhMuc , GiamGia.maGiamGia , MonAn.giaTien FROM MonAn " +
                " INNER JOIN DanhMuc ON MonAn.id_DanhMuc = DanhMuc.id_DanhMuc " +
                " INNER JOIN GiamGia ON Monan.id_GiamGia = GiamGia.id_GiamGia";
        return getData(sql);
    }

    public MonAn getID(String id){
        String sql = "SELECT * FROM MonAn WHERE id_MonAn=?";
        List<MonAn> list = getData(sql,id);
        return list.get(0);
    }
    public List<MonAn> getData(String sql , String...selectionArgs){
        List<MonAn> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        if(c!=null && c.getCount()>0){
            c.moveToFirst();
            do {
                int id_MonAn = c.getInt(0);
                String tenMonAn = c.getString(1);
                int id_DanhMuc = c.getInt(2);
                int id_GiamGia = c.getInt(3);
                int GiaTien = c.getInt(4);
                MonAn monAn = new MonAn();
                monAn.setId_MonAn(id_MonAn);
                monAn.setTenMonAn(tenMonAn);
                monAn.setId_DanhMuc(id_DanhMuc);
                monAn.setId_GiamGia(id_GiamGia);
                monAn.setGiaTien(GiaTien);
                list.add(monAn);
            }while (c.moveToNext());
        }
        return list;
    }
}
