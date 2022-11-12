package com.example.expenso.view.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.expenso.R;
import com.example.expenso.util.AuthService;

public class SignUp extends AppCompatActivity {
    EditText regEmail,  regPassword;
    Button  btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //init widget for signUp Activity
        regEmail = findViewById(R.id.regEmail);
        regPassword = findViewById(R.id.regPassword);
        btnSignUp = findViewById(R.id.btnSignUp);

        // Handle CLick event
        btnSignUp.setOnClickListener(v -> {
            String email = regEmail.getText().toString();
            String password = regPassword.getText().toString();

            new AuthService().signUpService(
                    email, password, v
            );
        });
    }
}