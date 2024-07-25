package com.example.ap_demo04;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;

public class MainActivityA4_BroadcaseReceiver extends AppCompatActivity {
    private final MyNetworkChangeReceiver myNetworkChangeReceiver = new MyNetworkChangeReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_a4);

        // Đăng ký receiver
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(myNetworkChangeReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Hủy đăng ký receiver
        unregisterReceiver(myNetworkChangeReceiver);
    }
}