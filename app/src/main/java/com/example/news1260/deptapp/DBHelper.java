package com.example.news1260.deptapp;

/**
 * Created by news1260 on 2015/8/19.
 */
import static android.provider.BaseColumns._ID; //這個是資料庫都會有個唯一的ID

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {

    //喧告公用常數(final)

    public static final String TABLE_NAME = "friends";  //表格名稱

    public static final String NAME = "name";

    public static final String TEL = "tel";

    public static final String EMAIL = "email";



    private final static String DATABASE_NAME = "demo.db";  //資料庫名稱

    private final static int DATABASE_VERSION = 1;  //資料庫版本

    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }



    @Override

    //建立table,有NAME、TEL、EMAIL 三個欄位

    public void onCreate(SQLiteDatabase db) {

        final String INIT_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " CHAR, " + TEL + " CHAR, " + EMAIL + " CHAR);";

        db.execSQL(INIT_TABLE);

    }



    @Override

    //刪除table

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

        db.execSQL(DROP_TABLE);

        onCreate(db);

    }

}