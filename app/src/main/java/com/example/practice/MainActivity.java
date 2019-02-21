package com.example.practice;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText etName;
    private EditText etPassword;
    private CheckBox isCheck;
    private SharedPreferences infoSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoSp = getSharedPreferences("info", MODE_PRIVATE);

        etName = findViewById(R.id.et_name);
        etPassword = findViewById(R.id.et_password);
        isCheck = findViewById(R.id.cb_isCheck);

        String name = infoSp.getString("name", "");
        String password = infoSp.getString("password", "");
        boolean check = infoSp.getBoolean("check", false);

        etName.setText(name);
        etPassword.setText(password);
        isCheck.setChecked(check);

    }


    public void login(View view) {
        String name = etName.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (isCheck.isChecked()) {
            infoSp.edit().putString("name", name)
                    .putString("password", password)
                    .putBoolean("check", true)
                    .apply();
            Toast.makeText(MainActivity.this, "保存成功" , Toast.LENGTH_SHORT).show();
        } else {infoSp.edit().putString("name", "")
                .putString("password", "")
                .putBoolean("check", false)
                .apply();
        }
    }

}

