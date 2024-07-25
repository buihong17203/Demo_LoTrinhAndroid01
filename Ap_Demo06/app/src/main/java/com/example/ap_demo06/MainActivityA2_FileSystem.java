package com.example.ap_demo06;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivityA2_FileSystem extends AppCompatActivity {

    private EditText editTextFileName, editTextFileContent;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_a2);

        editTextFileName = findViewById(R.id.editTextFileName);
        editTextFileContent = findViewById(R.id.editTextFileContent);
        textViewResult = findViewById(R.id.textViewResult);
        Button buttonCreate = findViewById(R.id.buttonCreate);
        Button buttonRead = findViewById(R.id.buttonRead);
        Button buttonDelete = findViewById(R.id.buttonDelete);

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createFile();
            }
        });

        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFile();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteFile();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void createFile() {
        String fileName = editTextFileName.getText().toString();
        String fileContent = editTextFileContent.getText().toString();
        try (FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE)) {
            fos.write(fileContent.getBytes());
            textViewResult.setText("File Created Successfully");
        } catch (IOException e) {
            e.printStackTrace();
            textViewResult.setText("Error Creating File");
        }
    }

    private void readFile() {
        String fileName = editTextFileName.getText().toString();
        try (FileInputStream fis = openFileInput(fileName)) {
            int size;
            StringBuilder sb = new StringBuilder();
            while ((size = fis.read()) != -1) {
                sb.append((char) size);
            }
            textViewResult.setText("File Content: " + sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
            textViewResult.setText("Error Reading File");
        }
    }

    private void deleteFile() {
        String fileName = editTextFileName.getText().toString();
        boolean deleted = deleteFile(fileName);
        if (deleted) {
            textViewResult.setText("File Deleted Successfully");
        } else {
            textViewResult.setText("Error Deleting File");
        }
    }
}
