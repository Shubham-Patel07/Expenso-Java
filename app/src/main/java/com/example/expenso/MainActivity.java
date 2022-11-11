package com.example.expenso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.expenso.view.Dashboard;
import com.example.expenso.view.auth.SignIn;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                    startActivity(new Intent(getApplicationContext(), Dashboard.class));
                    finish();
                } else {
                    startActivity(new Intent(getApplicationContext(), SignIn.class));
                    finish();
                }
            }
        },2000);
    }
}