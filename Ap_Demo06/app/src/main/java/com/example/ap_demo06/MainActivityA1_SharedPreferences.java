package com.example.ap_demo06;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityA1_SharedPreferences extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_a1);

        //Tạo hoặc truy xuất dữ liệu
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        //Lữu Dữ Liệu
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("key", "value"); // Lưu một chuỗi
        editor.putInt("key", 123); // Lưu một số nguyên
        editor.putBoolean("key", true); // Lưu một giá trị boolean
        editor.apply(); // Lưu các thay đổi một cách bất đồng bộ (khuyến khích sử dụng thay vì commit())


        //Đọc Dữ Liệu
        String value = sharedPreferences.getString("key", "default_value");
        String myString = sharedPreferences.getString("key", "default_value");
        int myInt = sharedPreferences.getInt("key", 0);
        boolean myBool = sharedPreferences.getBoolean("key", false);


        //Xóa Dữ Liệu
        SharedPreferences.Editor editor1 = sharedPreferences.edit();
        editor1.remove("key");
        editor1.clear(); // Xóa tất cả các giá trị trong Shared Preferences
        editor1.apply(); // Lưu các thay đổi một cách bất đồng bộ




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}