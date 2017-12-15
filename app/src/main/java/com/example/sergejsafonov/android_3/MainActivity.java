package com.example.sergejsafonov.android_3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

//import static com.example.sergejsafonov.android_3.SharedPrefCreate.APP_PREFERENCES_ACTIVITY;

public class MainActivity extends AppCompatActivity {

//    private static final String APP_PREFERENCES_ACTIVITY = "mylastactivity";
    SharedPreferences mSettings;
    SharedPrefCreate sharedPrefCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View btn_L1 = (Button) findViewById(R.id.btn_L1);
        View btn_L2 = (Button) findViewById(R.id.btn_L2);
        View btn_L3 = (Button) findViewById(R.id.btn_L3);

        View.OnClickListener oclBtnL1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Lab1.class);
                startActivity(intent);
            }
        };



        btn_L1.setOnClickListener(oclBtnL1);

        View.OnClickListener oclBtnL2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Lab2.class);
                        startActivity(intent);
            }
        };
        btn_L2.setOnClickListener(oclBtnL2);


        View.OnClickListener oclBtnL3 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Lab3.class);
                startActivity(intent);
            }
        };
        btn_L3.setOnClickListener(oclBtnL3);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

//        mSettings = getSharedPreferences(APP_PREFERENCES_ACTIVITY, Context.MODE_PRIVATE);

//        sharedPrefCreate = new SharedPrefCreate(this.getClass(), mSettings);



//        if(!mSettings.contains(APP_PREFERENCES_ACTIVITY)) {
//            MenuItem shareMenuItem = menu.findItem(R.id.second_menu_actionbar);
//            shareMenuItem.setVisible(false);
//        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.second_menu_actionbar:


//                Class<?> cls = null;
//                try {
//                    cls = Class.forName(sharedPrefCreate.getSharedPref(APP_PREFERENCES_ACTIVITY));
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
//                Object obj = cls.newInstance();

                Button btn = findViewById(R.id.btn_L3);
//                btn.setText(sharedPrefCreate.getSharedPref(APP_PREFERENCES_ACTIVITY));


//                Object object = new Gson().fromJson(sharedPrefCreate.getSharedPref(APP_PREFERENCES_ACTIVITY), Object.class);


//                Intent intent = new Intent(MainActivity.this, sharedPrefCreate.getSharedPref(APP_PREFERENCES_ACTIVITY));
//                startActivity(intent);

                return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
