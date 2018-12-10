package com.example.fahri.luke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.support.v7.widget.Toolbar;

public class Kubus extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kubus);

        toolbar = (Toolbar) findViewById(R.id.toolbar_kubus);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void bt_kubus1 (View view){

        Intent intent = new Intent(this,VKubus.class);
        startActivity(intent);
    }

    public void bt_kubus2 (View view){

        Intent intent = new Intent(this,LPKubus.class);
        startActivity(intent);
    }
}
