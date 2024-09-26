package com.example.patientpal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.patientpal.fragments.ServiceFragment;

public class TimeDB extends SQLiteOpenHelper {

    private static final String DB_NAME="TaskTime";
    private static final String TABLE_NAME="Service Time";
    private  static final String ID="id";
    private static final String SERVICE_NAME ="service_name";
    private static final String SERVICE_PRICE="price";
    public TimeDB(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
           db.execSQL(" CREATE TABLE " + TABLE_NAME +
                  "(" + ID + "INTEGER PRIMARY KEY, " + SERVICE_NAME + " TEXT," + SERVICE_PRICE + " INTEGER " + ")" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
    }

    public void insertData(int id, String task, int price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ID,id);
        values.put(SERVICE_NAME,task);
        values.put(SERVICE_PRICE,price);

        db.insert(TABLE_NAME,null,values);
    }

}

