package com.example.fahri.luke;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
    }

    public void cardview1 (View view){

        Intent kubus = new Intent(this,Kubus.class);
        startActivity(kubus);
    }

    public void cardview2 (View view){

        Intent balok = new Intent(this,Balok.class);
        startActivity(balok);
    }

    public void cardview3 (View view){

        Intent tabung = new Intent(this,Tabung.class);
        startActivity(tabung);
    }

    public void cardview4 (View view){

        Intent prisma = new Intent(this,Prisma.class);
        startActivity(prisma);
    }

    public void cardview5 (View view){

        Intent limas_segi_empat = new Intent (this,LimasSegiEmpat.class);
        startActivity(limas_segi_empat);
    }

    public void cardview6 (View view){

        Intent limas_segi_tiga = new Intent(this,LimasSegiTiga.class);
        startActivity(limas_segi_tiga);
    }

    public void cardview7 (View view){

        Intent kerucut = new Intent(this,Kerucut.class);
        startActivity(kerucut);
    }

    public void cardview8 (View view){

        Intent bola = new Intent(this,Bola.class);
        startActivity(bola);
    }
}
