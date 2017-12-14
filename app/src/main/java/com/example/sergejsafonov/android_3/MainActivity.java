package com.example.sergejsafonov.android_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuPurchasesListNewRecord:
                // TODO: обработчик нажатия здесь
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
