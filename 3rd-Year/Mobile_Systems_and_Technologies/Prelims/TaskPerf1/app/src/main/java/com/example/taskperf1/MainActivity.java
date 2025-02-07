package com.example.taskperf1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button websiteBtn;
    private Button linkedinBtn;
    private Button youtubeBtn;
    private Button facebookBtn;

    private ImageView historyBtn;
    private ImageView billsBtn;
    private ImageView usersBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            websiteBtn = findViewById(R.id.websiteBtn);
            linkedinBtn = findViewById(R.id.linkedinBtn);
            youtubeBtn = findViewById(R.id.youtubeBtn);
            facebookBtn = findViewById(R.id.facebookBtn);

            historyBtn = findViewById(R.id.historyImage);
            billsBtn = findViewById(R.id.billImage);
            usersBtn = findViewById(R.id.accountsImage);

            websiteBtn.setOnClickListener(v -> toast("You have clicked the website button!"));
            linkedinBtn.setOnClickListener(v -> toast("You have clicked the LinkedIn button!"));
            youtubeBtn.setOnClickListener(v -> toast("You have clicked the YouTube button!"));
            facebookBtn.setOnClickListener(v -> toast("You have clicked the Facebook button!"));

            historyBtn.setOnClickListener(v -> toast("You have clicked the history icon!"));
            billsBtn.setOnClickListener(v -> toast("You have clicked the bills icon!"));
            usersBtn.setOnClickListener(v -> toast("You have clicked the users icon!"));
        } catch (Exception err) {
            err.printStackTrace();
            toast(err.getMessage());
        }
    }

    private void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}