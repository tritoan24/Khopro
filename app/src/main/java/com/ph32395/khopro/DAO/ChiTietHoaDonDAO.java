package com.ph32395.khopro.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ph32395.khopro.Database.DbHelper;
import com.ph32395.khopro.Model.ChiTietHoaDon;

import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDonDAO {
    private static final String TABLE_NAME = "ChiTietHoaDon";
    private static final String COLUMN_ID = "id_ChiTietHoaDon";
    private static final String COLUMN_HOA_DON_ID = "id_HoaDon";
    // Thêm các cột khác của bảng ChiTietHoaDon

    DbHelper dbHelper;
    SQLiteDatabase db;

    public ChiTietHoaDonDAO(Context context) {
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long Insert(ChiTietHoaDon chiTietHoaDon) {
        ContentValues values = new ContentValues();
        values.put("tenMonAn", chiTietHoaDon.getTenMonAn());
        values.put("soLuong", chiTietHoaDon.getSoLuong());
        values.put("giaTien", chiTietHoaDon.getGiaTien());
        values.put("tongTien", chiTietHoaDon.getTongTien());
        // Set giá trị cho các cột trong bảng ChiTietHoaDon
        values.put(COLUMN_HOA_DON_ID, chiTietHoaDon.getId_HoaDon());
        // Thêm các giá trị cho các cột khác của bảng ChiTietHoaDon

        long insertedRowId = db.insert(TABLE_NAME, null, values);

        // Kiểm tra khi insert thành công
        if (insertedRowId != -1) {
            // Gọi phương thức kiểm tra
            boolean isSuccess = checkInsertSuccess(insertedRowId);
            if (isSuccess) {
                Log.d("Insert ChiTietHoaDon", "Thành công");
            } else {
                Log.d("Insert ChiTietHoaDon", "Thất bại");
            }
        } else {
            Log.d("Insert ChiTietHoaDon", "Thất bại");
        }

        return insertedRowId;
    }

    private boolean checkInsertSuccess(long insertedRowId) {
        String[] columns = {COLUMN_ID};
        String selection = COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(insertedRowId)};

        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);

        boolean isSuccess = cursor.moveToFirst();
        cursor.close();
        return isSuccess;
    }

    public int Update(ChiTietHoaDon chiTietHoaDon) {
        try {
            ContentValues values = new ContentValues();
            values.put(COLUMN_HOA_DON_ID, chiTietHoaDon.getId_HoaDon());
            // Thêm các giá trị cho các cột khác của bảng ChiTietHoaDon

            return db.update(TABLE_NAME, values, COLUMN_ID + "=?", new String[]{String.valueOf(chiTietHoaDon.getId_ChiTietHoaDon())});
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int Delete(ChiTietHoaDon chiTietHoaDon) {
        try {
            return db.delete(TABLE_NAME, COLUMN_ID + "=?", new String[]{String.valueOf(chiTietHoaDon.getId_ChiTietHoaDon())});
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @SuppressLint("Range")
    public List<ChiTietHoaDon> getData(String sql, String... selectionArgs) {
        List<ChiTietHoaDon> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql, selectionArgs);
        while (c.moveToNext()) {
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
            chiTietHoaDon.setId_ChiTietHoaDon(c.getInt(c.getColumnIndex(COLUMN_ID)));

            String idHoaDon = c.getString(c.getColumnIndex(COLUMN_HOA_DON_ID));
            chiTietHoaDon.setId_HoaDon(idHoaDon != null ? Integer.parseInt(idHoaDon) : 0);

            // Thêm lấy giá trị cho các cột khác của bảng ChiTietHoaDon
            // ...

            list.add(chiTietHoaDon);
        }
        c.close();
        return list;
    }

    public List<ChiTietHoaDon> getAll() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        return getData(sql);
    }

    public ChiTietHoaDon getID(String id) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + "=?";
        List<ChiTietHoaDon> list = getData(sql, id);
        return list.get(0);
    }

    @SuppressLint("Range")
    public List<ChiTietHoaDon> getIdChiTietHoaDonByRowId(int hoadonid) {
        List<ChiTietHoaDon> danhsach = new ArrayList<>();
        String query = "SELECT * FROM ChiTietHoaDon WHERE id_HoaDon = "+hoadonid;

        Cursor cursor = db.rawQuery(query,null);

        if (cursor!=null) {
            while (cursor.moveToNext()) {
                @SuppressLint("Range") int id_ChiTietHoaDon = cursor.getInt(cursor.getColumnIndex("id_ChiTietHoaDon"));
                @SuppressLint("Range") String tenMonAn = cursor.getString(cursor.getColumnIndex("tenMonAn"));
                @SuppressLint("Range") int soLuong = cursor.getInt(cursor.getColumnIndex("soLuong"));
                @SuppressLint("Range") int giaTien = cursor.getInt(cursor.getColumnIndex("giaTien"));
                @SuppressLint("Range") int tongTien = cursor.getInt(cursor.getColumnIndex("tongTien"));

                @SuppressLint("Range") int id_HoaDon = cursor.getInt(cursor.getColumnIndex("id_HoaDon"));

                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(id_ChiTietHoaDon, id_HoaDon, tenMonAn, soLuong, giaTien, tongTien);
                danhsach.add(chiTietHoaDon);

            }
            cursor.close();
        }

        return danhsach;
    }
    @SuppressLint("Range")
    public List<ChiTietHoaDon> layDanhSachHoaDonChiTietTheoIdHoaDon(int idHoaDon) {
        List<ChiTietHoaDon> listHoaDonChiTiet = new ArrayList<>();

        String query = "SELECT * FROM ChiTietHoaDon WHERE id_HoaDon = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(idHoaDon)});

        if (cursor.moveToFirst()) {
            do {
                ChiTietHoaDon hoaDonChiTiet = new ChiTietHoaDon();
                hoaDonChiTiet.setId_ChiTietHoaDon(cursor.getInt(cursor.getColumnIndex("id_ChiTietHoaDon")));
                hoaDonChiTiet.setId_HoaDon(cursor.getInt(cursor.getColumnIndex("id_HoaDon")));
                hoaDonChiTiet.setTenMonAn(cursor.getString(cursor.getColumnIndex("tenMonAn")));
                hoaDonChiTiet.setSoLuong(cursor.getInt(cursor.getColumnIndex("soLuong")));
                hoaDonChiTiet.setGiaTien(cursor.getInt(cursor.getColumnIndex("giaTien")));
                hoaDonChiTiet.setTongTien(cursor.getInt(cursor.getColumnIndex("tongTien")));

                listHoaDonChiTiet.add(hoaDonChiTiet);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return listHoaDonChiTiet;
    }



}
