package com.christianphan.mednew;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "STOCKLIST.db";
    public static final String TABLE_NAME = "STOCK_TABLE";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "USERNAME"; //1
    public static final String COL_3 = "PASSWORD"; //2
    public static final String COL_4 = "EMAIL";   //3
    public static final String COL_5 = "FIRSTNAME";  //4
    public static final String COL_6 = "LASTNAME";   //5
    public static final String COL_7 = "OTHERINDEX";   //6



    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {

            String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                    + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " TEXT,"
                    + COL_3 + " TEXT," + COL_4 + " TEXT," + COL_5 + " TEXT," + COL_6 + " TEXT," +
                    COL_7 + " TEXT" +  ")";

            db.execSQL(CREATE_CONTACTS_TABLE);
            Log.w("myApp", "Created");

        }
        catch(Exception e)
        {
            Log.w("myApp", "Not Created");

        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }


    public boolean insertData(String username, String password, String email, String firstname, String lastname, String index2)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2, username);
        contentValues.put(COL_3, password);
        contentValues.put(COL_4, email);
        contentValues.put(COL_5, firstname);
        contentValues.put(COL_6, lastname);
        contentValues.put(COL_7, index2);

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


}
