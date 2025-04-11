package com.example.registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    public static final String IS_SAME = "isSame";

    private View view;
    private EditText firstText, secondText;
    private Button swapBtn, checkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindElements();
        setButtons();
    }

    private void bindElements() {
        view = findViewById(R.id.main);
        firstText = findViewById(R.id.firstText);
        secondText = findViewById(R.id.secondText);
        swapBtn = findViewById(R.id.swapBtn);
        checkBtn = findViewById(R.id.checkBtn);
    }

    private void setButtons() {
        swapBtn.setOnClickListener(v -> {
            String temp = firstText.getText().toString();
            firstText.setText(secondText.getText());
            secondText.setText(temp);
            snackbar("Swapped!");
        });
        checkBtn.setOnClickListener(v -> {
            String firstStr = firstText.getText().toString();
            String secondStr = secondText.getText().toString();

            if (firstStr.isEmpty() || secondStr.isEmpty()) {
                snackbar("All fields are required!");
                return;
            }

            Intent intent = new Intent(this, CheckActivity.class);
            intent.putExtra(IS_SAME, firstStr.equals(secondStr));
            startActivity(intent);
        });
    }

    private void snackbar(String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }
}