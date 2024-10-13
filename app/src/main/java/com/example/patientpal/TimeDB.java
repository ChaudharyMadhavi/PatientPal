package com.example.patientpal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TimeDB extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "TimeDB.db";
    public static final String TABLE_NAME = "tasks";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "TASK_NAME";
    public static final String COL_3 = "AMOUNT";

    public TimeDB(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creating the tasks table
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, TASK_NAME TEXT, AMOUNT INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Method to insert task data
    public boolean insertData(int id, String taskName, int amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, taskName);
        contentValues.put(COL_3, amount);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    // Method to retrieve all tasks and their amounts
    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase(); // Use getReadableDatabase() for reading data
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
}
