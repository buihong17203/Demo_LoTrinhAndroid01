package com.example.ap_demo04;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyDatabase";
    private static final int DATABASE_VERSION = 1;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng trong cơ sở dữ liệu
        db.execSQL("CREATE TABLE IF NOT EXISTS MyTable ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Thực hiện nâng cấp cơ sở dữ liệu khi có phiên bản mới
        db.execSQL("DROP TABLE IF EXISTS MyTable");
        onCreate(db);

    }
}
