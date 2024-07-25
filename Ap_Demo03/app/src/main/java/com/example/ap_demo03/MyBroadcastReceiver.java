package com.example.ap_demo03;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "BroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Broadcast Received");
    }
}

/*Broadcast Receiver là thành phần cho phép một ứng dụng nhận các thông báo (broadcast) từ hệ thống hoặc từ các ứng dụng khác.
Broadcast Receiver không có giao diện người dùng, nó chỉ thực hiện hành động cụ thể khi nhận được thông báo.*/