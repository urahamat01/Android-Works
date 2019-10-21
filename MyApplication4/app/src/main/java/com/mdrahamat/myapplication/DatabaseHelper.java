package com.mdrahamat.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "User.db";
    private static String TABLE_NAME = "User";
    public static String COL_ID ="Id";
    public static String COL_NAME ="Name";
    public static String COL_AGE = "Age";
    private static int VERSION = 1;
    private String createTable = "create table "+TABLE_NAME+
"(Id INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Age TEXT)";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    public long insertData(String name, String age){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME,name);
        contentValues.put(COL_AGE,age);
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        long id = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
        return id;
    }

    public Cursor showData() {

        String show_all ="SELECT * From "+TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
       Cursor cursor= sqLiteDatabase.rawQuery(show_all,null);
       return cursor;

    }
}
