package com.example.moonc.cse_ru_3_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by moonc on 10/19/2017.
 */

public class Sql_helper_for_routin extends SQLiteOpenHelper {


    public static String DatabaseName = "routine1.db";
    public static int Version = 1;
    public static String COL_1 = "time_";
    public  static String COL_2 = "class_name";

    String query = "Create table if not exists Saturday  ( " + COL_1 + " TEXT , " + COL_2 + " TEXT );";
    String query_sun = "Create table if not exists Sunday  ( " + COL_1 + " TEXT , " + COL_2 + " TEXT );";
    String query_mon = "Create table if not exists Monday  ( " + COL_1 + " TEXT , " + COL_2 + " TEXT );";
    String query_tue = "Create table if not exists Tuesday  ( " + COL_1 + " TEXT , " + COL_2 + " TEXT );";
    String query_wed = "Create table if not exists Wednesday  ( " + COL_1 + " TEXT , " + COL_2 + " TEXT );";
    String query_thu = "Create table if not exists Thursday  ( " + COL_1 + " TEXT , " + COL_2 + " TEXT );";


    Edit_Data edit_data = new Edit_Data();






    public Sql_helper_for_routin(Context context) {
        super(context, DatabaseName, null, Version);
    }

    public void CreatingTable()
    {
        SQLiteDatabase db = getWritableDatabase();
         db.execSQL(query);
         db.execSQL(query_sun);
         db.execSQL(query_mon);
         db.execSQL(query_tue);
         db.execSQL(query_wed);
         db.execSQL(query_thu);

    }

    public void drop(String Table_name)
    {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "drop table " + Table_name;
        db.execSQL(sql);
        CreatingTable();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       // Table_name = edit_data.FileName;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        String query = " drop table " + ;
//        db.execSQL(query);
//        onCreate(db);

    }


    public boolean add(String time, String CLass_,String Table_name)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("time_",time);
        contentValues.put("class_name",CLass_);
        SQLiteDatabase db  = getWritableDatabase();
       long result =  db.insert(Table_name,null,contentValues);
        if(result<0)
        {
            return false;

        }else
            return true;
    }

    public Cursor show(String tableName)
    {

        SQLiteDatabase db = getWritableDatabase();
        String query = "select * from " + tableName ;
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }
}
