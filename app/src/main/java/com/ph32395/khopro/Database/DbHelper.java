package com.ph32395.khopro.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    static String DB_NAME = "UngDungDatDoAn";
    static int DB_VERSION = 3;

    static final String CREATE_TABLE_MONAN = "CREATE TABLE MonAn (" +
            "    id_MonAn   INTEGER PRIMARY KEY AUTOINCREMENT," +
            "    tenMonAn TEXT    NOT NULL," +
            "    id_DanhMuc  INTEGER REFERENCES DanhMuc (id_DanhMuc)," +
            "    id_GiamGia INTEGER REFERENCES GiamGia(id_GiamGia)," +
            "    giaTien  MONEY    NOT NULL )";

    static final String CREATE_TABLE_DANHMUC = "CREATE TABLE DanhMuc (" +
            " id_DanhMuc INTEGER PRIMARY KEY AUTOINCREMENT," +
            " tenDanhMuc TEXT NOT NULL)";

    static final String CREATE_TABLE_NHANVIEN = "CREATE TABLE NhanVien (" +
            "    maNhanVien    TEXT PRIMARY KEY," +
            "    hoTen    TEXT    NOT NULL," +
            "    tuoi INTEGER ," +
            "    gioiTinh TEXT ," +
            "    soDienThoai TEXT ," +
            "    matKhau TEXT NOT NULL," +
            "    loaiTaiKhoan TEXT" +
            ")";

    static final String CREATE_TABLE_BANAN = "CREATE TABLE BanAn (" +
            " id_BanAn INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " soBan INTEGER NOT NULL)";

    static final String CREATE_TABLE_HOADON = "CREATE TABLE HoaDon (" +
            " id_HoaDon INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " id_MonAn INTEGER NOT NULL REFERENCES MonAn (id_MonAn), " +
            " id_NhanVien TEXT NOT NULL REFERENCES NhanVien (maNhanVien), " +
            " id_BanAn INTEGER  REFERENCES BanAn (id_BanAn), " +
            " id_GiamGia INTEGER REFERENCES GiamGia(id_GiamGia)," +
            " soLuong INTEGER NOT NULL," +
            " ngayGio TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
            " giaTien INTEGER NOT NULL," +
            " kieuThanhToan TEXT NOT NULL, " +
            " tongTien MONEY)";

    static final String CREATE_TABLE_GIAMGIA = "CREATE TABLE GiamGia(" +
            "id_GiamGia INTEGER PRIMARY KEY AUTOINCREMENT," +
            "maGiamGia TEXT NOT NULL," +
            "phanTramGiam INTEGER" +
            ")";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_DANHMUC);
        db.execSQL(CREATE_TABLE_NHANVIEN);
        db.execSQL(CREATE_TABLE_MONAN);
        db.execSQL(CREATE_TABLE_BANAN);
        db.execSQL(CREATE_TABLE_HOADON);
        db.execSQL(CREATE_TABLE_GIAMGIA);
        db.execSQL(DataSql.INSERT_TB_NHANVIEN);
        db.execSQL(DataSql.INSERT_TB_BANAN);
        db.execSQL(DataSql.INSERT_TB_DANHMUC);
        db.execSQL(DataSql.INSERT_TB_MONAN);
        db.execSQL(DataSql.INSERT_TB_GIAMGIA);
        db.execSQL(DataSql.INSERT_TB_HOADON);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i != i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS MonAn");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DanhMuc");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS NhanVien");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS BanAn");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS HoaDon");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS GiamGia");

            onCreate(sqLiteDatabase);
        }
    }
}

