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

import static com.example.sergejsafonov.android_3.SharedPrefCreate.APP_PREFERENCES_ACTIVITY;

public class MainActivity extends AppCompatActivity {

    SharedPreferences mSettings;
    SharedPrefCreate sharedPrefCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSettings = getSharedPreferences(APP_PREFERENCES_ACTIVITY, Context.MODE_PRIVATE);


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

        // проверяем, первый ли раз открывается программа
        boolean hasVisited = mSettings.getBoolean("hasVisited", false);

        if (!hasVisited) {
            MenuItem lastactivity = menu.findItem(R.id.second_menu_actionbar);
            MenuItem reset = menu.findItem(R.id.reset);
            lastactivity.setVisible(false);
            reset.setVisible(false);
        }

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        sharedPrefCreate = new SharedPrefCreate(mSettings);

        switch (item.getItemId()) {

            case R.id.second_menu_actionbar:


                Class<?>  myclass = null;
                String name = sharedPrefCreate.getSharedPref(APP_PREFERENCES_ACTIVITY);
                try {
                    myclass = Class.forName(name);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(this, myclass);

                startActivity(intent);

                return true;

            case R.id.reset:
                sharedPrefCreate.reset();

        }

        return super.onOptionsItemSelected(item);
    }



}
