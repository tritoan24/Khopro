package com.ph32395.khopro.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ph32395.khopro.Database.DbHelper;
import com.ph32395.khopro.Model.ChiTietHoaDon;
import com.ph32395.khopro.Model.MonAn;

import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDonDAO {
    DbHelper dbHelper;
    SQLiteDatabase db;
    public ChiTietHoaDonDAO(Context context){
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long Insert(ChiTietHoaDon chiTietHoaDon){
        try {
            ContentValues values = new ContentValues();
            values.put("id_HoaDon", chiTietHoaDon.getId_HoaDon());
            values.put("id_MonAn", chiTietHoaDon.getId_MonAn());
            values.put("soLuong", chiTietHoaDon.getSoLuong());
            values.put("tongTien", chiTietHoaDon.getTongTien());
            return db.insert("ChiTietHoaDon", null, values);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public int Update(ChiTietHoaDon chiTietHoaDon){
        try {
            ContentValues values = new ContentValues();
            values.put("id_HoaDon", chiTietHoaDon.getId_HoaDon());
            values.put("id_MonAn", chiTietHoaDon.getId_MonAn());
            values.put("soLuong", chiTietHoaDon.getSoLuong());
            values.put("tongTien", chiTietHoaDon.getTongTien());
            return db.update("ChiTietHoaDon", values, "id_ChiTietHoaDon=?", new String[]{String.valueOf(chiTietHoaDon.getId_ChiTietHoaDon())});
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public  int Delete(ChiTietHoaDon chiTietHoaDon){
        try{
            return db.delete("ChiTietHoaDon","id_ChiTietHoaDon=?",new String[]{String.valueOf(chiTietHoaDon.getId_ChiTietHoaDon())});
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @SuppressLint("Range")
    public List<ChiTietHoaDon> getData(String sql , String...selectionArgs){
        List<ChiTietHoaDon> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
            chiTietHoaDon.setId_ChiTietHoaDon(Integer.parseInt(c.getString(c.getColumnIndex("id_ChiTietHoaDon"))));

            String idHoaDon = c.getString(c.getColumnIndex("id_HoaDon"));
            chiTietHoaDon.setId_HoaDon(idHoaDon != null ? Integer.parseInt(idHoaDon) : 0);

            String idMonAn = c.getString(c.getColumnIndex("id_MonAn"));
            chiTietHoaDon.setId_MonAn(idMonAn != null ? Integer.parseInt(idMonAn) : 0);

            chiTietHoaDon.setSoLuong(Integer.parseInt(c.getString(c.getColumnIndex("soLuong"))));
            chiTietHoaDon.setTongTien(Integer.parseInt(c.getString(c.getColumnIndex("tongTien"))));
            list.add(chiTietHoaDon);
        }
        return list;
    }

    public List<ChiTietHoaDon>getAll(){
        String sql = "Select * from ChiTietHoaDon";
        return getData(sql);
    }

    public ChiTietHoaDon getID(String id){
        String sql = "SELECT * FROM ChiTietHoaDon WHERE id_ChiTietHoaDon=?";
        List<ChiTietHoaDon> list = getData(sql,id);
        return list.get(0);
    }
}
