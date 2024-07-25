package com.example.ap_demo05;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityA5_Fragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_a5);

        // Kiểm tra nếu savedInstanceState là null để tránh thêm Fragment nhiều lần
        if (savedInstanceState == null) {
            // Tạo mới Fragment
            MySecondFragment firstFragment = new MySecondFragment();

            // Thêm Fragment vào container
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment)
                    .commit();
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        return false;
    }
}