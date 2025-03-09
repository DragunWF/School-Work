package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // onClick="register" replaced with onClickListeners (Modern conventions)

    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String USERNAME = "username";

    private EditText firstNameText, lastNameText, usernameText,
                     passwordText, confirmPasswordText;
    private Button createBtn, showPasswordBtn;

    private boolean isShowPassword = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            firstNameText = findViewById(R.id.firstNameText);
            lastNameText = findViewById(R.id.lastNameText);
            usernameText = findViewById(R.id.usernameText);
            passwordText = findViewById(R.id.passwordText);
            confirmPasswordText = findViewById(R.id.confirmPasswordText);

            createBtn = findViewById(R.id.createBtn);
            showPasswordBtn = findViewById(R.id.showPasswordBtn);

            setButtons();
        } catch (Exception err) {
            err.printStackTrace();
            toast(err.getMessage());
        }
    }

    private void setButtons() {
        createBtn.setOnClickListener(v -> {
            String firstName = getText(firstNameText);
            String lastName = getText(lastNameText);
            String username = getText(usernameText);
            String password = getText(passwordText);
            String confirmPassword = getText(confirmPasswordText);

            if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty()
                    || password.isEmpty() || confirmPassword.isEmpty()) {
                toast("Do not leave any of the fields empty!");
                return;
            }
            if (!password.equals(confirmPassword)) {
                toast("Password and confirm password fields do not match!");
                return;
            }

            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            intent.putExtra(FIRST_NAME, firstName);
            intent.putExtra(LAST_NAME, lastName);
            intent.putExtra(USERNAME, username);
            startActivity(intent);
            toast("You have successfully logged in!");
        });
        showPasswordBtn.setOnClickListener(v -> {
            isShowPassword = !isShowPassword;

            int inputType = isShowPassword ? InputType.TYPE_TEXT_VARIATION_NORMAL : InputType.TYPE_TEXT_VARIATION_PASSWORD;
            passwordText.setInputType(inputType);
            confirmPasswordText.setInputType(inputType);
        });
    }

    private String getText(EditText text) {
        return String.valueOf(text.getText());
    }

    private void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}