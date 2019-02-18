package com.example.practice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etPassword;
    private CheckBox cbCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etPassword = findViewById(R.id.et_password);
        cbCheck = findViewById(R.id.cb_isCheck);

        Map<String, String> maps = UserInfoUtils.readInfo();
        String name = maps.get("name");
        String password = maps.get("password");

        etName.setText(name);
        etPassword.setText(password);

    }


    public void login(View view) {
        String name = etName.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "用戶名或密碼不能為空", Toast.LENGTH_LONG).show();
        } else {
            if (cbCheck.isChecked()) {
                boolean result = UserInfoUtils.saveInfo(name, password);
                if (result) {
                    Toast.makeText(this, "保存成功", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "保存失敗", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "請勾選", Toast.LENGTH_LONG).show();
            }
        }
    }
}

