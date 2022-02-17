package com.example.tutorial_one;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlite_islemleri extends SQLiteOpenHelper {
    public sqlite_islemleri(Context c){
        super(c,"kullanici_bilgileri",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table bilgiler( top_cik_level INTEGER, bol_level INTEGER, carp_level INTEGER,id primary key)";
        db.execSQL(sql);
        sql =  "INSERT INTO bilgiler (top_cik_level,bol_level,carp_level,id) VALUES (0,0,0,0)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table bilgiler");
    }
}
