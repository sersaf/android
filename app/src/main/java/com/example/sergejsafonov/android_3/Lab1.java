package com.example.sergejsafonov.android_3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.sergejsafonov.android_3.SharedPrefCreate.APP_PREFERENCES_ACTIVITY;

public class Lab1 extends AppCompatActivity {

    private TextView textView;
    SharedPreferences mSettings;
    SharedPrefCreate sharedPrefCreate;
    public static final int MENU_AUTHOR = 1;
    public static final int MENU_RESET = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
        mSettings = getSharedPreferences(APP_PREFERENCES_ACTIVITY, Context.MODE_PRIVATE);

        View authorButton = (Button) findViewById(R.id.authorButton);
        registerForContextMenu(authorButton);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(Menu.NONE, MENU_AUTHOR, Menu.NONE, R.string.author);
        menu.add(Menu.NONE, MENU_RESET, Menu.NONE, R.string.reset);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        CharSequence message;
        switch (item.getItemId())
        {
            case MENU_AUTHOR:
                StringBuilder name = new StringBuilder();
                Resources res = getResources();
                name.append(res.getString(R.string.fio))
                        .append(" ").append(res.getString(R.string.group));

                getAuthor(name.toString());
                break;
            case MENU_RESET:
                resetField();
                break;

        }
        return super.onContextItemSelected(item);

    }

    public void getAuthor(final String str) {
        textView = (TextView) findViewById(R.id.textView);

        textView.setText(str);

    }

    public void resetField(){
        String text = getResources().getString(R.string.work);
        textView.setText(text);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        sharedPrefCreate = new SharedPrefCreate("com.example.sergejsafonov.android_3.Lab1", mSettings);


        // проверяем, первый ли раз открывается программа
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
    public boolean onPrepareOptionsMenu(Menu menu) {

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
                invalidateOptionsMenu();
        }

        return super.onOptionsItemSelected(item);
    }

}
