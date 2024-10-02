package com.example.campusconnect;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        // Get references to the dots and logo
        View dot1 = findViewById(R.id.dot1);
        View dot2 = findViewById(R.id.dot2);
        View dot3 = findViewById(R.id.dot3);
        View dot4 = findViewById(R.id.dot4);
        ImageView logo = findViewById(R.id.app_logo);

        // Start the loading animation
        animateDots(dot1, dot2, dot3, dot4, logo);
    }

    private void animateDots(View dot1, View dot2, View dot3, View dot4, View logo) {
        // Dots appear one by one
        new Handler().postDelayed(() -> fadeIn(dot1, 300), 0);
        new Handler().postDelayed(() -> fadeIn(dot2, 300), 300);
        new Handler().postDelayed(() -> fadeIn(dot3, 300), 600);
        new Handler().postDelayed(() -> fadeIn(dot4, 300), 900);

        // Simulate loading and transition to WelcomeActivity
        new Handler().postDelayed(() -> {
            // Start fade-out animation for the logo
            fadeOut(logo, 500);

            // Fade out the dots after the logo
            fadeOut(dot1, 500);
            fadeOut(dot2, 500);
            fadeOut(dot3, 500);
            fadeOut(dot4, 500);

            // After the fade out of the dots, transition to WelcomeActivity
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(LoadingActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }, 1000); // Wait for dots to fade out
        }, 3000); // Keep loading for 3 seconds
    }

    private void fadeIn(View view, int duration) {
        AlphaAnimation fadeIn = new AlphaAnimation(0, 1); // From invisible to visible
        fadeIn.setDuration(duration);
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // No action needed
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(fadeIn);
    }

    private void fadeOut(View view, int duration) {
        AlphaAnimation fadeOut = new AlphaAnimation(1, 0); // From visible to invisible
        fadeOut.setDuration(duration);
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(fadeOut);
    }
}
