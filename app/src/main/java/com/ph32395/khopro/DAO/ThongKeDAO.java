package com.ph32395.khopro.DAO;

import android.content.Context;

import com.ph32395.khopro.Database.DbHelper;

public class ThongKeDAO {
    DbHelper dbHelper;
    public ThongKeDAO(Context context){
        dbHelper = new DbHelper(context);
    }

}
