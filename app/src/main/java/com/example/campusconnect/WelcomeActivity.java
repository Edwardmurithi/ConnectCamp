// src/main/java/com/yourpackage/WelcomeActivity.java
package com.example.campusconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    private Button loginButton, welcomeButton;
    private TextView signupText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Initialize views
        loginButton = findViewById(R.id.loginButton);
        welcomeButton = findViewById(R.id.welcomeButton);
        signupText = findViewById(R.id.signupText);

        // Navigate to LoginActivity on login button click
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        // Navigate to HomeActivity on welcome button click
        welcomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });

        // Navigate to SignupActivity on sign-up text click
        signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupIntent = new Intent(WelcomeActivity.this, SignUpActivity.class);
                startActivity(signupIntent);
            }
        });
    }
}
