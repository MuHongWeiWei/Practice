package com.example.practice;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TextInfoUtils {
    public static boolean saveInfo(Context context, String name, String password) {

        String result = name + "##" + password;
        try {
            FileOutputStream fos = context.openFileOutput("Memberinfo.txt", Context.MODE_PRIVATE);
            fos.write(result.getBytes());
            fos.flush();
            fos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Map<String, String> readInfo(Context context) {

        Map<String, String> maps = new HashMap<>();
        try {
            FileInputStream fis = context.openFileInput("Memberinfo.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = br.readLine();
            String[] split = line.split("##");
            maps.put("name", split[0]);
            maps.put("password", split[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return maps;
    }
}
