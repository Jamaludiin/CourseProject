package com.example.courseproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_username, et_email, et_password, et_confirm_password;
    private Button btn_register;
    private TextView tv_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // You can add your form handling logic here
        tv_login = findViewById(R.id.tv_login);


        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startViewRecord = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(startViewRecord);
            }
        });

    }
}


