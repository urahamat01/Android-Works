package com.mdrahamat.mysecondactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    private static String DATABASE_NAME = "User.bd";
    public static String TABLE_NAME = "User";
    public static String COL_ID = "Id";
    public static String COL_NAME = "Name";
    public static String COL_AGE = "Age";
    private static int VERSION = 1;
    private String createTable = "create table "+TABLE_NAME+"("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_NAME+" TEXT, "+COL_AGE+" TEXT)";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        Log.d(TAG, "DatabaseHelper: DATABASEHELPER");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate: onCreate Method");
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade: onUpgrade Method");

    }
    public long insertData(String name, String age){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME,name);
        contentValues.put(COL_AGE,age);
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        long id = sqLiteDatabase.insert(DATABASE_NAME,null,contentValues);
        sqLiteDatabase.close();
        return id;

    }
    public Cursor showData(){
        String show_all =" SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
       Cursor cursor = sqLiteDatabase.rawQuery(show_all,null);
       return cursor;

    }
}
