package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CheckActivity extends AppCompatActivity {
    private TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        bindElements();
        setDetails();
    }

    private void bindElements() {
        displayText = findViewById(R.id.displayText);
    }

    private void setDetails() {
        boolean isSame = getIntent().getBooleanExtra(MainActivity.IS_SAME, false);
        displayText.setText(isSame ? "SAME" : "NOT THE SAME");
    }
}