package com.example.courseproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText et_username, et_password;
    private Button btn_login;
    private TextView tv_forgot_password, tv_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        btn_login = findViewById(R.id.btn_login);

        tv_forgot_password = findViewById(R.id.tv_forgot_password);
        tv_register = findViewById(R.id.tv_register);

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startViewRecord = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(startViewRecord);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startViewRecord = new Intent(MainActivity.this, AppointmentActivity.class);
                startActivity(startViewRecord);
            }
        });

    }
}