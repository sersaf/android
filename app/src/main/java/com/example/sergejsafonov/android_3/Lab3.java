package com.example.sergejsafonov.android_3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import static com.example.sergejsafonov.android_3.SharedPrefCreate.APP_PREFERENCES_ACTIVITY;

public class Lab3 extends AppCompatActivity {
    SharedPreferences mSettings;
    SharedPrefCreate sharedPrefCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3);
        mSettings = getSharedPreferences(APP_PREFERENCES_ACTIVITY, Context.MODE_PRIVATE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        sharedPrefCreate = new SharedPrefCreate("com.example.sergejsafonov.android_3.Lab3", mSettings);

        boolean hasVisited = mSettings.getBoolean("hasVisited", false);

        if (!hasVisited) {
            MenuItem lastactivity = menu.findItem(R.id.second_menu_actionbar);
            MenuItem reset = menu.findItem(R.id.reset);
            lastactivity.setVisible(false);
            reset.setVisible(false);
            SharedPreferences.Editor e = mSettings.edit();
            e.putBoolean("hasVisited", true);
            e.apply();
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.second_menu_actionbar:


                Class<?> myclass = null;
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
