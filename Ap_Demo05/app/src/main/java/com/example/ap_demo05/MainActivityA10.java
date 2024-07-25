package com.example.ap_demo05;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;

public class MainActivityA10_Ani extends AppCompatActivity {

    private View square;
    private Button btnAnimate;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_a10);


        square = findViewById(R.id.square);
        btnAnimate = findViewById(R.id.btnAnimate);

        btnAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateSquare();
            }

            private void animateSquare() {
            }
        });



            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }
    }
    private void animateSquare () {
        // Animation for translation
        ObjectAnimator translateX = ObjectAnimator.ofFloat(square, "translationX", 300f);
        translateX.setDuration(1000);

        // Animation for color change
        ObjectAnimator colorChange = ObjectAnimator.ofArgb(square, "backgroundColor", Color.BLUE, Color.RED);
        colorChange.setDuration(1000);

        // Combine animations
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(translateX, colorChange);
        animatorSet.start();
}