package com.example.sergejsafonov.android_3;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lab1 extends AppCompatActivity {

    private TextView textView;
    public static final int MENU_AUTHOR = 1;
    public static final int MENU_RESET = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);

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

}
