package com.example.tutorial_one;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlite_veriAl {
    SQLiteDatabase db;
    sqlite_islemleri benim_db;
    public sqlite_veriAl(Context c){
        benim_db = new sqlite_islemleri(c);

    }
    public void ac(){
        db = benim_db.getWritableDatabase();
    }
    public void kapat(){
        benim_db.close();
    }
    public void top_cik_level_degistir(int yeni_level){
        ContentValues degerler = new ContentValues();
        degerler.put("top_cik_level",yeni_level);
        db.update("bilgiler",degerler,"id = 0",null);
    }
    public void bol_level_degistir(int yeni_level){
        ContentValues degerler = new ContentValues();
        degerler.put("bol_level",yeni_level);
        db.update("bilgiler",degerler,"id = 0",null);
    }
    public void carp_level_degistir(int yeni_level){
        ContentValues degerler = new ContentValues();
        degerler.put("carp_level",yeni_level);
        db.update("bilgiler",degerler,"id = 0",null);
    }
    public int top_cik_level_kac(){
        String kolonlar[] = {"top_cik_level"};
        Cursor c =db.query("bilgiler",kolonlar,null,null,null,null,null);
        c.moveToFirst();
        int deger = 0;
        while(!c.isAfterLast()){
            deger  =c.getInt(0);
            break;
        }
        return deger;
    }
    public int bol_level_kac(){
        String kolonlar[] = {"bol_level"};
        Cursor c =db.query("bilgiler",kolonlar,null,null,null,null,null);
        c.moveToFirst();
        int deger = 0;
        while(!c.isAfterLast()){
            deger  =c.getInt(0);
            break;
        }
        return deger;
    }
    public int carp_level_kac(){
        String kolonlar[] = {"carp_level"};
        Cursor c =db.query("bilgiler",kolonlar,null,null,null,null,null);
        c.moveToFirst();
        int deger = 0;
        while(!c.isAfterLast()){
            deger  =c.getInt(0);
            break;
        }
        return deger;
    }
}
