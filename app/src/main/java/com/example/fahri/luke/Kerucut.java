package com.example.fahri.luke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.support.v7.widget.Toolbar;

public class Kerucut extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kerucut);

        toolbar = (Toolbar) findViewById(R.id.toolbar_kerucut);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void bt_kerucut1 (View view){

        Intent intent  = new Intent(this,VKerucut.class);
        startActivity(intent);
    }

    public void bt_kerucut2 (View view){

        Intent intent = new Intent(this,LPKerucut.class);
        startActivity(intent);
    }
}
