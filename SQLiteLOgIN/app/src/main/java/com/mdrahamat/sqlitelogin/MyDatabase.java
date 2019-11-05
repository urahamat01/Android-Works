package com.mdrahamat.sqlitelogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "student.db";
    private static final String TABLE_NAME = "student";
    private static final String ID = "Id";
    private static final String NAME = "Name";
    private static final String EMAIL = "Email";
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    private static final String DROP_TABLE = " DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VERCHER(250) NOT NULL, " + EMAIL + " TEXT NOT NULL, " + USERNAME + " TEXT NOT NULL,"+PASSWORD+" TEXT NOT NULL);";
    private static int VERSION = 2;
    private Context context;

    public MyDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context, "OnCreate Method", Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            Toast.makeText(context, "Exception Table is ", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            Toast.makeText(context, " onUpgrade is Called ", Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (Exception e) {
            Toast.makeText(context, " Exception onUpgrade ", Toast.LENGTH_SHORT).show();

        }
    }

    //video 30
  /*  public long insertData(String name, String age, String gender) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(AGE, age);
        contentValues.put(GENDER, gender);
       long id = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
       return id;


    }

   */



    //Video 31

   /* public Cursor showData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL,null);
        return cursor;
*//*

    }*/

    // video 33

    /*public boolean updateData(String id, String name, String age, String gender) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, id);
        contentValues.put(NAME, name);
        contentValues.put(AGE, age);
        contentValues.put(GENDER, gender);
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID+"=?",new String[]{id});
        return true;

    }
    */


   /* public int deleteData(String id) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
       return sqLiteDatabase.delete(TABLE_NAME,ID+ " = ?",new String[]{id});
    }*/

}
