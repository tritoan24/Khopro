package com.ph32395.khopro.DAO;

import android.companion.WifiDeviceFilter;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ph32395.khopro.Database.DbHelper;
import com.ph32395.khopro.Model.BanAn;

import java.util.ArrayList;

public class BanAnDAO {
    DbHelper dbHelper;

    public BanAnDAO(Context context){
        dbHelper = new DbHelper(context);
    }

    public ArrayList<BanAn> getListBanAn(){
        ArrayList<BanAn> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_BanAn", null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do{
                list.add(new BanAn(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public boolean insert(BanAn banAn){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("soBan", banAn.getSoBan());
        values.put("trangThai", banAn.getTrangThai());
        long check = db.insert("tb_BanAn", null, values);
        if(check == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long check = db.delete("tb_BanAn","id_BanAn = ?",new String[]{String.valueOf(id)});
        if(check == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean update(BanAn banAn){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("soBan", banAn.getSoBan());
        values.put("trangThai", banAn.getTrangThai());
        long check = db.update("tb_BanAn",values,"id_BanAn = ?",new String[]{String.valueOf(banAn.getId_BanAn())});
        if(check == -1){
            return false;
        }else{
            return true;
        }
    }
}
