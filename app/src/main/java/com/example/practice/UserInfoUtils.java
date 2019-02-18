package com.example.practice;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class UserInfoUtils {

    public static boolean saveInfo (String name, String password) {
        String result = name + "##" + password;
        try {
            File file = new File("data/data/com.example.practice/info.txt");
            FileWriter fw = new FileWriter(file);
            fw.write(result);
            fw.flush();
            fw.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Map<String, String> readInfo() {
        try {
            Map<String, String> maps = new HashMap<>();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream("data/data/com.example.practice/info.txt")));
            String s = br.readLine();
            String[] split = s.split("##");

            maps.put("name", split[0]);
            maps.put("password", split[1]);
            return maps;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
