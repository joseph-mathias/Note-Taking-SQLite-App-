package com.nchimunya.sqliteapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.os.Build.ID;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Table Name
    public static final String TABLE_NAME = "COUNTRIES";

    // Table Columns
    public static final String _ID = "_id";
    public static final String SUBJECT = "subject";
    public static final String DESCRIPTION = "description";

    //  Database Information
    static final String DB_NAME = "Android_One.DB";

    // Database Version
    static final int DB_VERSION = 1;

    // Creating Table Query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +
            "(" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SUBJECT +
            " TEXT NOT NULL, " + DESCRIPTION + " TEXT );";

    // Constructor
    public DatabaseHelper (Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Executing the Query
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
