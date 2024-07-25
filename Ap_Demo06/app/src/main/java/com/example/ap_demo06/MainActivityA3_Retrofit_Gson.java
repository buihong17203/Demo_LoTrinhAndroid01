package com.example.ap_demo06;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivityA3_Retrofit_Gson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_a3);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set up Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of the ApiService
        ApiService service = retrofit.create(ApiService.class);

        // Make an API call
        Call<List<Repo>> repos = service.listRepos("octocat");
        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if (response.isSuccessful()) {
                    List<Repo> repos = response.body();
                    // Handle the received data
                    for (Repo repo : repos) {
                        Log.d("Repo", "Name: " + repo.getName());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                // Handle the error
                Log.e("Error", t.getMessage(), t);
            }
        });

        // Gson usage examples
        Gson gson = new Gson();

        // Deserialize JSON to Java object
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        User user = gson.fromJson(json, User.class);
        Log.d("Gson", "User name: " + user.getName() + ", age: " + user.getAge());

        // Serialize Java object to JSON
        User userObject = new User("John", 30);
        String jsonString = gson.toJson(userObject);
        Log.d("Gson", "Serialized JSON: " + jsonString);
    }

    public interface ApiService {
        @GET("users/{user}/repos")
        Call<List<Repo>> listRepos(@Path("user") String user);
    }

    public class Repo {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
