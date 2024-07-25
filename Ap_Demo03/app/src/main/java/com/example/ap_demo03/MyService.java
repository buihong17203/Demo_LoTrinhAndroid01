package com.example.ap_demo03;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service
{

    private static final String TAG = "Service";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Service Created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Service Started");
        // Thực hiện các tác vụ dài hạn tại đây
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service Destroyed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}


/*Service là một thành phần trong Android chạy ngầm, thực hiện các thao tác trong thời gian dài mà không cần giao diện người dùng.
 Service có thể được khởi động và tiếp tục chạy ngay cả khi người dùng chuyển sang ứng dụng khác. Có hai loại Service chính:

    - Started Service: Được khởi động bởi một thành phần khác và chạy độc lập.
    - Bound Service: Cho phép các thành phần khác gắn kết (bind) để tương tác với Service.*/
