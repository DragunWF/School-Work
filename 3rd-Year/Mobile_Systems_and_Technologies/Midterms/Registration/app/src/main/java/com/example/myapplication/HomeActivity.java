package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private TextView headerText, fullNameText, usernameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        try {
            headerText = findViewById(R.id.headerText);
            fullNameText = findViewById(R.id.fullNameText);
            usernameText = findViewById(R.id.usernameText);

            setData();
        } catch (Exception err) {
            err.printStackTrace();
            toast(err.getMessage());
        }
    }

    private void setData() {
        String firstName = getIntent().getStringExtra(MainActivity.FIRST_NAME);
        String lastName = getIntent().getStringExtra(MainActivity.LAST_NAME);
        String username = getIntent().getStringExtra(MainActivity.USERNAME);

        headerText.setText(String.format("Welcome to Lothern, %s!", firstName));
        fullNameText.setText(String.format("Full Name: %s %s", firstName, lastName));
        usernameText.setText(String.format("Username: %s", username));
    }

    private void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}