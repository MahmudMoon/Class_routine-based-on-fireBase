package com.example.moonc.cse_ru_3_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by moonc on 10/30/2017.
 */

public class Sql_helper_for_notifications extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "Notifications.db";
    public static final String TABLE_NAME = "Notification";
    public static final int DATABASE_VERSION = 1;
    public static final String COL_1 = "Title";
    public static final String COl_2 = "detail";

    public Sql_helper_for_notifications(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table if not exists " + TABLE_NAME + " ( " + COL_1 + "  text , " + COl_2 + " text );";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean add(String title, String detail)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Title",title);
        contentValues.put("detail",detail);

        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }

    public Cursor showData()
    {
        SQLiteDatabase db = getWritableDatabase();
        String query = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }

    public void drop(){
        SQLiteDatabase db = getWritableDatabase();
        String sql  = "drop table if exists " + TABLE_NAME ;
        db.execSQL(sql);
        onCreate(db);
    }

    public boolean check(String title,String Message)
    {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "Select * from " + TABLE_NAME + " where Title = " + title + " , detail = " + Message ;
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.getCount()>0)
            return false;
        else
            return true;
    }


}
