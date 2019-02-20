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
    private CheckBox cbIsCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etPassword = findViewById(R.id.et_password);
        cbIsCheck = findViewById(R.id.cb_isCheck);

        Map<String, String> maps = TextInfoUtils.readInfo(this);

        String name = maps.get("name");
        String password = maps.get("password");

        etName.setText(name);
        etPassword.setText(password);

    }


    public void login(View view) {
        String name = etName.getText().toString();
        String password = etPassword.getText().toString();

        if (cbIsCheck.isChecked()) {
            boolean succes = TextInfoUtils.saveInfo(MainActivity.this, name, password);
            if (succes) {
                Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "保存失敗", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "請勾選記住", Toast.LENGTH_LONG).show();
        }
    }
}

