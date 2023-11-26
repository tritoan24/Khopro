package com.ph32395.khopro.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    static String DB_NAME = "UngDungDatDoAn";
    static int DB_VERSION = 2;

   static final String cr_tb_MonAn = "CREATE TABLE tb_MonAn (" +
            "    id_MonAn   INTEGER PRIMARY KEY AUTOINCREMENT," +
            "    ten_MonAn TEXT    NOT NULL," +
            "    id_DanhMuc  INTEGER   NOT NULL REFERENCES tb_DanhMuc (id_DanhMuc)," +
            "    giaTien  INTEGER    NOT NULL )";

   static final String cr_tb_DanhMuc = "CREATE TABLE tb_DanhMuc (" +
            " id_DanhMuc INTEGER PRIMARY KEY AUTOINCREMENT," +
            " ten_DanhMuc TEXT NOT NULL)";

   static final String CREATE_TABLE_NHANVIEN = "CREATE TABLE NhanVien (" +
            "    maNhanVien    TEXT PRIMARY KEY," +
            "    hoTen    TEXT    NOT NULL," +
            "    matKhau TEXT NOT NULL," +
            "    loaitaikhoan TEXT"+
            ")";

   static final String cr_tb_BanAn = "CREATE TABLE tb_BanAn ("+
            " id_BanAn INTEGER PRIMARY KEY AUTOINCREMENT, "+
            " soBan INTEGER NOT NULL, "+
            " trangThai TEXT NOT NULL)";

   static final String cr_tb_HoaDon = "CREATE TABLE tb_HoaDon ("+
            " id_HoaDon INTEGER PRIMARY KEY AUTOINCREMENT, "+
            " id_MonAn INTEGER NOT NULL REFERENCES tb_MonAn (id_MonAn), "+
            " id_NhanVien INTEGER NOT NULL REFERENCES tb_NhanVien (id_NhanVien), "+
            " id_BanAn INTEGER NOT NULL REFERENCES tb_BanAn (id_BanAn), "+
            " ngayTao DATE NOT NULL, "+
            " giaTien INTEGER NOT NULL,"+
            " kieuThanhToan TEXT NOT NULL, "+
            " trangThai TEXT NOT NULL)";

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
