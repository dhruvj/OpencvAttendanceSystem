package com.example.opencv_attendance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "Attendance_System";
 
    // Contacts table name
    private static final String TABLE_CONTACTS = "classes";
 
  
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE classes " +
        		"(" +
        		"cid INTEGER PRIMARY KEY AUTOINCREMENT," +
        		"cname TEXT" +
        		")");
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
 
        // Create tables again
        onCreate(db);
    }
    void addClass(String className) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put("cname", className); // Contact Phone
 
        // Inserting Row
        db.insert("classes", null, values);
        db.close(); // Closing database connection
    }
    String getClass(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query("classes", new String[] { "cid",
                "cname" }, "cid" + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        // return contact
        return cursor.getString(1);
    }
}