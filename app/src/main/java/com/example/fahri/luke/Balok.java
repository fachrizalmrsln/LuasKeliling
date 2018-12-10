package com.example.fahri.luke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.support.v7.widget.Toolbar;

public class Balok extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balok);

        toolbar = (Toolbar) findViewById(R.id.toolbar_balok);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void bt_balok1 (View view){

        Intent intent = new Intent(this,VBalok.class);
        startActivity(intent);

    }

    public void bt_balok2 (View view){

        Intent intent = new Intent(this,LPBalok.class);
        startActivity(intent);
    }
}
