package com.example.ap_demo07;

import android.os.Bundle;
import android.util.Log;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;
import java.util.List;

public class MainActivityA2_Sqlite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_a2);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Tạo database instance
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
        AppDatabase.class, "database-name").allowMainThreadQueries().build();

        // Lấy UserDao
        UserDao userDao = db.userDao();

        // Tạo một user mới
        User user = new User();
        user.name = "John Doe";
        user.email = "john.doe@example.com";

        // Chèn user vào database
        userDao.insertAll(user);

        // Lấy tất cả users từ database
        List<User> users = userDao.getAll();

        // Log các user để kiểm tra
        for (User u : users) {
            Log.d("MainActivityA2_Sqlite", "User: " + u.name + ", Email: " + u.email);
        }
    }
}