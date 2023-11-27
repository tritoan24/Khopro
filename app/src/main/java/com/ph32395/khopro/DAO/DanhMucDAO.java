package com.ph32395.khopro.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ph32395.khopro.Database.DbHelper;
import com.ph32395.khopro.Model.BanAn;
import com.ph32395.khopro.Model.DanhMucMonAn;

import java.util.ArrayList;

public class DanhMucDAO {
    DbHelper dbHelper;

    public DanhMucDAO(Context context){
        dbHelper = new DbHelper(context);
    }

    public ArrayList<DanhMucMonAn> getListDanhMuc(){
        ArrayList<DanhMucMonAn> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_DanhMuc", null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do{
                list.add(new DanhMucMonAn(cursor.getInt(0), cursor.getString(1)));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public long insert(DanhMucMonAn danhMuc){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_DanhMuc", danhMuc.getId_DanhMuc());
        values.put("ten_DanhMuc", danhMuc.getTenDanhMuc());
        return db.insert("tb_DanhMuc", null, values);
    }

    public long delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.delete("tb_DanhMuc","id_DanhMuc = ?",new String[]{String.valueOf(id)});

    }

    public long update(DanhMucMonAn danhMuc){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ten_DanhMuc", danhMuc.getTenDanhMuc());
        return db.update("tb_DanhMuc",values,"id_DanhMuc = ?",new String[]{String.valueOf(danhMuc.getId_DanhMuc())});
    }
}
