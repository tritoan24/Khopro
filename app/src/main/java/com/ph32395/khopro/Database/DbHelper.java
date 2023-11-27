package com.ph32395.khopro.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    static String DB_NAME = "UngDungDatDoAn";
    static int DB_VERSION = 2;

   static final String CREATE_TABLE_MONAN = "CREATE TABLE MonAn (" +
            "    id_MonAn   INTEGER PRIMARY KEY AUTOINCREMENT," +
            "    tenMonAn TEXT    NOT NULL," +
            "    id_DanhMuc  INTEGER REFERENCES DanhMuc (id_DanhMuc)," +
            "    id_GiamGia INTEGER REFERENCES GiamGia(id_GiamGia),"+
            "    giaTien  MONEY    NOT NULL )";

   static final String CREATE_TABLE_DANHMUC = "CREATE TABLE DanhMuc (" +
            " id_DanhMuc INTEGER PRIMARY KEY AUTOINCREMENT," +
            " tenDanhMuc TEXT NOT NULL)";

   static final String CREATE_TABLE_NHANVIEN = "CREATE TABLE NhanVien (" +
            "    maNhanVien    TEXT PRIMARY KEY," +
            "    hoTen    TEXT    NOT NULL," +
            "    matKhau TEXT NOT NULL," +
            "    loaitaikhoan TEXT"+
            ")";

   static final String CREATE_TABLE_BANAN = "CREATE TABLE BanAn ("+
            " id_BanAn INTEGER PRIMARY KEY AUTOINCREMENT, "+
            " soBan INTEGER NOT NULL, ";

   static final String CREATE_TABLE_HOADON = "CREATE TABLE HoaDon ("+
            " id_HoaDon INTEGER PRIMARY KEY AUTOINCREMENT, "+
            " id_MonAn INTEGER NOT NULL REFERENCES MonAn (id_MonAn), "+
            " id_NhanVien INTEGER NOT NULL REFERENCES NhanVien (id_NhanVien), "+
            " id_BanAn INTEGER  REFERENCES BanAn (id_BanAn), "+
            " id_GiamGia INTEGER REFERENCES GiamGia(id_GiamGia),"+
            " soLuong INTEGER NOTNULL,"+
            " gioVao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"+
            " ngayTao DATE NOT NULL, "+
            " giaTien INTEGER NOT NULL,"+
            " kieuThanhToan TEXT NOT NULL, "+
            " tongTien MONEY)";
   static final String CREATE_TABLE_GIAMGIA = "CREATE TABLE GiamGia("+
           "id_GiamGia INTEGER PRIMARY KEY AUTOICREMENT,"+
           "maGiamGia TEXT NOT NULL,"+
           "phanTramGiam INTEGER"+
           ")";

    public DbHelper (Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_NHANVIEN);
        db.execSQL(DataSql.INSERT_TB_NHANVIEN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i != i1){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_MonAn");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_DanhMuc");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_NhanVien");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_BanAn");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_HoaDon");

            onCreate(sqLiteDatabase);
        }
    }


}
