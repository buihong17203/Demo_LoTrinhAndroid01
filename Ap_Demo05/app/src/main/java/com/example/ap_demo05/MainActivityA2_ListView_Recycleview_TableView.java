package com.example.ap_demo05;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.GridView;
import android.widget.TableLayout;

public class MainActivityA2_ListView_Recycleview_TableView extends AppCompatActivity {

    ListView listView;
    RecyclerView recyclerView;
    GridView gridView;
    TableLayout tableLayout;

    // Định nghĩa mảng items của bạn
    String[] items = {"Mục 1", "Mục 2", "Mục 3"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_a2);

        // Cài đặt RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Cài đặt quản lý bố cục
        MyAdapter adapter = new MyAdapter(items); // Truyền mảng items vào adapter
        recyclerView.setAdapter(adapter); // Đặt adapter cho RecyclerView

        // Cài đặt ListView
        listView = findViewById(R.id.listView);
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(listAdapter);

        // Cài đặt GridView
        gridView = findViewById(R.id.gridView);
        ArrayAdapter<String> gridAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, items);
        gridView.setAdapter(gridAdapter);

        // Áp dụng lề cho bố cục chính
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        return false;
    }
}
