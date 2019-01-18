package com.example.fahri.luke;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Bola extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bola);

        toolbar = (Toolbar) findViewById(R.id.toolbar_bola);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void bt_bola1 (View view){

        Intent intent = new Intent(this,VBola.class);
        startActivity(intent);
    }

    public void bt_bola2 (View view){

        Intent intent = new Intent(this,LPBola.class);
        startActivity(intent);
    }
}
