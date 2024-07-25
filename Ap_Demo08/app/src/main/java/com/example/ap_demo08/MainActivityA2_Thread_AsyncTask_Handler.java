package com.example.ap_demo08;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.net.URL;

public class MainActivityA2_Thread_AsyncTask_Handler extends AppCompatActivity {

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

        // Example usage of Thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Background work here
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Update UI here
                    }
                });
            }
        }).start();

        // Example usage of AsyncTask
        new DownloadFilesTask().execute();

        // Example usage of Handler
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                // Work to be done
            }
        });
    }

    private class DownloadFilesTask extends AsyncTask<URL, Integer, Long> {
        protected Long doInBackground(URL... urls) {
            // Background work here
            return null;
        }

        protected void onProgressUpdate(Integer... progress) {
            // Update progress here
        }

        protected void onPostExecute(Long result) {
            // Update UI after background work is done
        }
    }
}
