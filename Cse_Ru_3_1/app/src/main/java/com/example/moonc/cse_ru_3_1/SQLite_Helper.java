package com.example.moonc.cse_ru_3_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by moonc on 10/16/2017.
 */

public class SQLite_Helper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "reminder.db";
    public static final String TABLE_NAME = "reminder_ct";
    public static final int DATABASE_VERSION = 1;
    public static final String COL_1 = "Date";
    public static final String COl_2 = "detail";




    public SQLite_Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table if not exists " + TABLE_NAME + " ( " + COL_1  + " TEXT , " + COl_2 + " TEXT );";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         String query  = "drop table if exists " + TABLE_NAME ;
        onCreate(db);
    }

    public boolean add(String date, String detail)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Date",date);
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


    public boolean delete(String val)
    {
        SQLiteDatabase db = getWritableDatabase();
        int result  =db.delete(TABLE_NAME,"detail = ?",new String[]{val});
        if(result==0)
            return false;
        else
            return true;

    }


}
