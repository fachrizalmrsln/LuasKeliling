package com.example.fahri.luke;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Tabung extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabung);

        toolbar = (Toolbar) findViewById(R.id.toolbar_tabung);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void bt_tabung1 (View view){

        Intent intent =  new Intent(this,VTabung.class);
        startActivity(intent);

    }

    public void bt_tabung2 (View view){

        Intent intent = new Intent(this,LPTabung.class);
        startActivity(intent);
    }
}
