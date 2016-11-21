package com.christianphan.mednew;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chris on 11/19/16.
 */

public class ActivityDataBase extends SQLiteOpenHelper{


    public static final String DATABASE_NAME = "ITM.db";
    public static final String TABLE_NAME = "ITM_TABLE";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "USER"; //1
    public static final String COL_3 = "INFO"; //2


    public ActivityDataBase(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {

            String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                    + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " TEXT,"
                    + COL_3 + " TEXT" +  ")";

            db.execSQL(CREATE_CONTACTS_TABLE);

        }
        catch(Exception e)
        {

        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean insertData(String username, String items)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2, username);
        contentValues.put(COL_3, items);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }


    public boolean upDate(String item)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_3, item);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }


    public boolean updateData(String id, String items)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_3, items);

        db.update(TABLE_NAME ,contentValues,"ID = ?",new String[] { id });
        return true;

    }

    public Cursor getLastData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor res = db.rawQuery(selectQuery, null);
        res.moveToLast();
        return res;


    }

}



