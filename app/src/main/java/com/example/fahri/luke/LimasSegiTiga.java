package com.example.fahri.luke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.support.v7.widget.Toolbar;

public class LimasSegiTiga extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limas_segi_tiga);

        toolbar = (Toolbar) findViewById(R.id.toolbar_limas_segi_tiga);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void bt_limas_segi_tiga1 (View view){

        Intent intent = new Intent(this,VLimasSegiTiga.class);
        startActivity(intent);
    }

    public void bt_limas_segi_tiga2 (View view){

        Intent intent = new Intent(this,LPLimasSegiTiga.class);
        startActivity(intent);
    }
}
