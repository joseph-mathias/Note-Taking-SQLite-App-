package com.nchimunya.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    private DatabaseHelper databaseHelper;
    private Context context;
    private SQLiteDatabase sqLiteDatabase;

    public DBManager(Context context){
        this.context = context;
    }

    public DBManager open() throws SQLException{
        databaseHelper = new DatabaseHelper(context);
        sqLiteDatabase= databaseHelper.getWritableDatabase();

        return this;
    }

    public void close(){
        databaseHelper.close();
    }

    public void insert(String name, String description){
        ContentValues contentValues = new ContentValues();

        contentValues.put(databaseHelper.SUBJECT, name);
        contentValues.put(DatabaseHelper.DESCRIPTION, description);

        sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }

    public Cursor fetch(){
        String[] columns = new String[]{
                DatabaseHelper._ID, DatabaseHelper.SUBJECT, DatabaseHelper.DESCRIPTION
        };

        Cursor cursor = sqLiteDatabase.query(DatabaseHelper.TABLE_NAME,
                columns, null, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        return cursor;
    }

    public int update(long _id, String name, String description){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.SUBJECT, name);
        contentValues.put(DatabaseHelper.DESCRIPTION, description);

        int i = sqLiteDatabase.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id){
        sqLiteDatabase.delete(DatabaseHelper.TABLE_NAME, databaseHelper._ID + " = " + _id ,null);
    }
}
