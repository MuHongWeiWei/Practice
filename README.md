# SP_Practice

## 儲存資料到Xml

#### 1.
    SharedPreferences sp = getSharedPreferences("info", MODE_PRIVATE);
#### 2.    
    sp.edit().putString("name", "qaz91097")
             .putString("password", "qazwsx123")
             .putBoolean("check", true)
             .apply();

## 從Xml取出資料

#### 1.
    SharedPreferences sp = getSharedPreferences("info", MODE_PRIVATE);
#### 2.
    String name = sp.getString("name", "");
    String password = sp.getString("password", "");
    boolean check = sp.getBoolean("check", false);
