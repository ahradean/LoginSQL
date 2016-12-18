package com.example.loginsql.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by d_doo on 12/18/2016.
 */

public class SQLController {
    private databaseHelper dbhelper;
    private Context context;
    private SQLiteDatabase db;

    public SQLController(Context c) {
        context = c;
    }

    public SQLController open() throws SQLException {
        dbhelper = new databaseHelper(context);
        db = dbhelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbhelper.close();
    }

    public void insertData(String name, String username, String password) {
        ContentValues cv = new ContentValues();
        cv.put(dbhelper.COL_NAME, name);
        cv.put(dbhelper.COL_USERNAME, username);
        cv.put(dbhelper.COL_PASSWORD, password);
        db.insert(dbhelper.TABLE_NAME, null, cv);

    }

    public Cursor readData() {
        String[] allColumns = new String[] {dbhelper.COL_ID,dbhelper.COL_NAME,dbhelper.COL_USERNAME,dbhelper.COL_PASSWORD};
        Cursor c = db.query(dbhelper.TABLE_NAME, allColumns, null,null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }



}
