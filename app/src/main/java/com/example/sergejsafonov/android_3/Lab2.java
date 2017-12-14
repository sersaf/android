package com.example.sergejsafonov.android_3;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Thread.sleep;

public class Lab2 extends AppCompatActivity {
    private TextView textView;
    private ProgressDialog progressDialog;
    public static final int MENU_AUTHOR = 1;
    public static final int MENU_RESET = 2;
    public static final int MENU_RATE = 3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
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
        menu.add(Menu.NONE, MENU_RATE, Menu.NONE, R.string.Rate);
    }

    public void getAuthor(final String str) {
        textView = (TextView) findViewById(R.id.textView);

        textView.setText(str);

    }

    public void resetField(){
        String text = getResources().getString(R.string.work);
        textView.setText(text);
    }

    public void showRateBlock(){

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.activity_rateactivity,
                (ViewGroup)findViewById(R.id.rateLayout));

        final String[] RateArray = {"1", "2", "3","4","5"};

        AlertDialog.Builder builder = new AlertDialog.Builder(Lab2.this);
        builder.setTitle("Оцените наше приложение")
                .setSingleChoiceItems(RateArray, -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int item) {

                            }
                        }) .setNegativeButton("Отмена",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }

                }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {

                rateInProgress();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                showToast();
            }

        });
        builder.setView(layout);



        AlertDialog alert = builder.create();
        alert.show();

    }

    public void rateInProgress(){
        Resources res = getResources();
        progressDialog = new ProgressDialog(this);
        progressDialog.show();
        progressDialog.setMessage(res.getString(R.string.review));

        new Thread(new Runnable() {
            @Override
            public void run(){
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();

            }
        }).start();





    }

    public void showToast(){
        Toast.makeText(this, R.string.thankForRate, Toast.LENGTH_SHORT).show();
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
            case MENU_RATE:
                showRateBlock();

        }
        return super.onContextItemSelected(item);

    }


    public void indWork(View view) {
        Intent intObj = new Intent(this, IndWork.class);
        startActivity(intObj);
    }
}