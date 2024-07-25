package com.example.ap_demo04;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Service Created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Service Started");

        // Thực hiện tác vụ chạy nền ở đây
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Ví dụ: Giả sử một tác vụ chạy nền
                try {
                    Thread.sleep(5000); // Giả lập tác vụ mất 5 giây
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Tác vụ hoàn thành
                Log.d(TAG, "Service Stopping");
                stopSelf();
            }
        }).start();

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service Destroyed");
    }
}

