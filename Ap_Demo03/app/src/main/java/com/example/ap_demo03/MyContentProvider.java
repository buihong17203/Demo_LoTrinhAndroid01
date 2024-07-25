package com.example.ap_demo03;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    @Override
    public boolean onCreate() {
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}

/*Content Provider là thành phần dùng để quản lý truy cập vào một tập dữ liệu có cấu trúc, nó cho phép các ứng dụng khác truy xuất và thao tác với dữ liệu.
Content Provider sử dụng một giao diện chuẩn để cung cấp dữ liệu thông qua các URI.*/
