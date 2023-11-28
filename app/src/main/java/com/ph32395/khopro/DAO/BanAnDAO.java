package com.ph32395.khopro.DAO;

import android.annotation.SuppressLint;
import android.companion.WifiDeviceFilter;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ph32395.khopro.Database.DbHelper;
import com.ph32395.khopro.Model.BanAn;

import java.util.ArrayList;
import java.util.List;

public class BanAnDAO {
    private SQLiteDatabase db;

    public BanAnDAO(Context context){
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public long insert(BanAn obj){
        ContentValues values = new ContentValues();
        values.put("soBan",obj.getSoBan());
        return db.insert("BanAn",null,values);
    }
    public int update(BanAn obj){
        ContentValues values = new ContentValues();
        values.put("soBan",obj.getSoBan());
        return db.update("BanAn",values,"id_BanAn = ?",new String[]{String.valueOf(obj.getId_BanAn())});
    }
    public int delete(String id){
        return db.delete("BanAn","id_BanAn=?",new String[]{id});
    }
    @SuppressLint("Range")
    public List<BanAn>getData(String sql, String...selectionArgs){
        List<BanAn>list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            BanAn obj = new BanAn();
            obj.setId_BanAn(Integer.parseInt(c.getString(c.getColumnIndex("id_BanAn"))));
            obj.setSoBan(Integer.parseInt(c.getString(c.getColumnIndex("soBan"))));
            list.add(obj);
        }
        return list;
    }
    public List<BanAn>getAll(){
        String sql = "Select * from BanAn";
        return getData(sql);
    }
    @SuppressLint("Range")
    public BanAn getBanAnByID(int id_BanAn) {
        String query = "SELECT * FROM BanAn WHERE id_BanAn = ?";
        String[] selectionArgs = {String.valueOf(id_BanAn)};

        Cursor cursor = db.rawQuery(query, selectionArgs);

        if (cursor.moveToFirst()) {
            BanAn banan = new BanAn();
            banan.setId_BanAn(cursor.getInt(cursor.getColumnIndex("id_BanAn")));
            banan.setSoBan(Integer.parseInt(cursor.getString(cursor.getColumnIndex("soBan"))));
            cursor.close();
            return banan;
        } else {
            cursor.close();
            return null; // Hoặc xử lý nếu không tìm thấy mã loại sách.
        }
    }
}