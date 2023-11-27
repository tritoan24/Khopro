package com.ph32395.khopro.DAO;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ph32395.khopro.Database.DbHelper;
import com.ph32395.khopro.Model.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {
    private SQLiteDatabase db;
    SharedPreferences sharedPreferences;
    DbHelper dbHelper;

    public NhanVienDAO(Context context) {
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
        sharedPreferences = context.getSharedPreferences("THONGTIN", MODE_PRIVATE);

    }
    public int updatePass(NhanVien obj) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("matKhau", obj.getMatKhau());
        int result = db.update("NhanVien", values, "maNhanVien=?", new String[]{obj.getMaNhanVien()});
        // db.close();  // Do not close the database here; let the calling code handle it
        return result;
    }

    public int delete (String id){
        return db.delete("NhanVien","maNhanVien=?",new String[]{id});
    }
    @SuppressLint("Range")
    public List<NhanVien> getData(String sql, String...selectionArgs) {
        List<NhanVien> list = new ArrayList<NhanVien>();
        Cursor c = db.rawQuery(sql, selectionArgs);
        while (c.moveToNext()) {
            NhanVien obj = new NhanVien();
            obj.setMaNhanVien((c.getString(c.getColumnIndex("maNhanVien"))));
            obj.setHoTen(c.getString(c.getColumnIndex("hoTen")));
            obj.setMatKhau(c.getString(c.getColumnIndex("matKhau")));
            list.add(obj);
        }
        return list;
    }
    public  List<NhanVien> getAll(){
        String sql = "Select * from NhanVien ";

        return getData(sql);
    }

    public NhanVien getID(String id){
        String sql = "Select * from NhanVien where maNhanVien=?";
        List<NhanVien> list = getData(sql, id);

        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            return null; // Trả về null nếu danh sách rỗng
        }
    }

    public int checkLogin(String id, String password) {
        SQLiteDatabase db = null;
        Cursor cursor = null;

        try {
            String[] columns = { "maNhanVien", "matKhau", "loaitaikhoan" };
            String selection = "maNhanVien = ? AND matKhau = ?";
            String[] selectionArgs = { id, password };

            db = dbHelper.getReadableDatabase();
            cursor = db.query("NhanVien", columns, selection, selectionArgs, null, null, null);

            if (cursor.moveToFirst()) {
                @SuppressLint("Range") String loaitaikhoan = cursor.getString(cursor.getColumnIndex("loaitaikhoan"));

                // Lưu loại tài khoản vào SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("loaitaikhoan", loaitaikhoan);
                editor.apply();

                return 1;
            } else {
                return -1;
            }
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            if (db != null && db.isOpen()) {
                db.close();
            }
        }
    }

    public long insert(NhanVien nhanVien) {
        ContentValues values = new ContentValues();
        values.put("maTT", nhanVien.getMaNhanVien());
        values.put("hoTen", nhanVien.getHoTen());
        values.put("matKhau", nhanVien.getMatKhau());

        return db.insert("NhanVien", null, values);
    }
}
