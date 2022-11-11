package com.example.expenso.view.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.expenso.R;
import com.example.expenso.util.AuthService;

public class SignIn extends AppCompatActivity {
    EditText logEmail, logPassword;
    Button btnSignIn;
    TextView txt_newUser;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // init widgets
        logEmail = findViewById(R.id.logEmail);
        logPassword = findViewById(R.id.logPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        txt_newUser = findViewById(R.id.txt_newUser);

        // Handle Click Event
        txt_newUser.setOnClickListener(v -> {
            startActivity(
                    new Intent(
                            this, SignUp.class
                    )
            );
        });


        btnSignIn.setOnClickListener(
                v -> {
            String email = logEmail.getText().toString();
            String password = logPassword.getText().toString();

            new AuthService().signInService(
                    email, password, v
            );
        });
    }
}