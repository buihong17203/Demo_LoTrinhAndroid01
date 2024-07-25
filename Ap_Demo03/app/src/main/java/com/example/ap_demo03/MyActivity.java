package com.example.ap_demo03;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MyActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Khởi động Service
            Intent serviceIntent = new Intent(this, MyService.class);
            startService(serviceIntent);

            // Khởi động Broadcast Receiver
            Intent broadcastIntent = new Intent("com.example.demoapp.MY_BROADCAST");
            sendBroadcast(broadcastIntent);
        }
}

/*Activity là thành phần cơ bản trong Android, đại diện cho một màn hình giao diện mà người dùng có thể tương tác.
Mỗi Activity được biểu diễn bằng một lớp kế thừa từ android.app.Activity.
Nó thường bao gồm việc quản lý vòng đời (lifecycle) của mình từ lúc được khởi tạo đến khi bị phá hủy.*/
