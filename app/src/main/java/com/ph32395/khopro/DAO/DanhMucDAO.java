package com.ph32395.khopro.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ph32395.khopro.Database.DbHelper;
import com.ph32395.khopro.Model.BanAn;
import com.ph32395.khopro.Model.DanhMucMonAn;
import com.ph32395.khopro.Model.MonAn;
import com.ph32395.khopro.Model.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class DanhMucDAO {
    DbHelper dbHelper;
    private SQLiteDatabase db;

    public DanhMucDAO(Context context){
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public ArrayList<DanhMucMonAn> getListDanhMuc(){
        ArrayList<DanhMucMonAn> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from DanhMuc", null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do{
                list.add(new DanhMucMonAn(cursor.getInt(0), cursor.getString(1)));
            }while (cursor.moveToNext());
        }
        return list;
    }
    @SuppressLint("Range")
    public List<DanhMucMonAn> getData(String sql , String...selectionArgs){
        List<DanhMucMonAn> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            DanhMucMonAn dm = new DanhMucMonAn();
            dm.setId_DanhMuc(Integer.parseInt(c.getString(c.getColumnIndex("id_DanhMuc"))));
            dm.setTenDanhMuc(c.getString(c.getColumnIndex("tenDanhMuc")));
            list.add(dm);
        }
        return list;
    }

    public long insert(DanhMucMonAn danhMuc){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_DanhMuc", danhMuc.getId_DanhMuc());
        values.put("tenDanhMuc", danhMuc.getTenDanhMuc());
        return db.insert("DanhMuc", null, values);
    }

    public long delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.delete("DanhMuc","id_DanhMuc = ?",new String[]{String.valueOf(id)});

    }

    public long update(DanhMucMonAn danhMuc){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenDanhMuc", danhMuc.getTenDanhMuc());
        return db.update("DanhMuc",values,"id_DanhMuc = ?",new String[]{String.valueOf(danhMuc.getId_DanhMuc())});
    }
    public DanhMucMonAn getID(String id){
        String sql = "Select * from DanhMuc where id_DanhMuc=?";
        List<DanhMucMonAn> list = getData(sql, id);

        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            return null; // Trả về null nếu danh sách rỗng
        }
    }
    public List<DanhMucMonAn>getAll(){
        String sql = "Select * from DanhMuc";
        return getData(sql);
    }

}
