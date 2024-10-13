package com.example.patientpal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TimeDB extends SQLiteOpenHelper {

    public static final String DBNAME = "TimeDB.db";

    public TimeDB(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tasks(id INTEGER PRIMARY KEY AUTOINCREMENT, taskName TEXT, amount INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tasks");
        onCreate(db);
    }

    // Method to insert data into the database
    public Boolean insertData(int id, String taskName, int amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("taskName", taskName);
        contentValues.put("amount", amount);

        long result = db.insert("tasks", null, contentValues);
        if (result == -1) {
            Log.e("Database", "Insert failed for task: " + taskName);
            return false; // if insertion fails
        }
        Log.d("Database", "Insert successful for task: " + taskName);
        return true; // insertion successful
    // if insertion fails, result will be -1
    }

    // Method to retrieve all data
    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM tasks", null);
    }


}
