package com.example.loginsql.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by d_doo on 12/18/2016.
 */

public class databaseHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "ACCOUNT.DB";
    static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "account";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";

    private static final String CREATE_TABLE = "create table "
            + TABLE_NAME + "(" + COL_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NAME + " TEXT NOT NULL, "+ COL_USERNAME + " TEXT NOT NULL," + COL_PASSWORD + "TEXT NOT NULL);";

    public databaseHelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        db.execSQL(CREATE_TABLE);
        cv.put(COL_ID,"1");
        cv.put(COL_NAME,"AndroidStudio");
        cv.put(COL_USERNAME,"Android");
        cv.put(COL_PASSWORD,"123456");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}
