package com.example.lenovo.application1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lenovo on 2017/9/17.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "players";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SCORE = "score";
    private static final String DATABASE_NAME = "players.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table " + TABLE_NAME
            + "(" + COLUMN_ID + " integer primary key autoincrement, "
            +COLUMN_NAME + " text not null, "
            +COLUMN_SCORE + " integer not null);";
    Context context;
    public DBHelper(Context context) { super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db){ db.execSQL(DATABASE_CREATE);}
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }


}
