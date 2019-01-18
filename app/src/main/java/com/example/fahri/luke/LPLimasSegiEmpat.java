package com.example.fahri.luke;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class LPLimasSegiEmpat extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText ETluasalas;
    private EditText ETluasselimut;
    private TextView TVPenjelasan;
    private Integer mLuasalas;
    private Integer mluasselimut;
    private Integer mJawabanLimas;
    private ScrollView SClplimasempat;
    private Button BTHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lplimas_segi_empat);

        toolbar = (Toolbar) findViewById(R.id.toolbar_lplimas_segi_empat);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TVPenjelasan = (TextView) findViewById(R.id.tv_penjelasan_rumus_lp_limasSegiEmpat);
        SClplimasempat = (ScrollView)findViewById(R.id.scroll_lplimasempat);

        TVPenjelasan.setText("Limas segiempat merupakan salah satu bangun ruang (3 dimensi) " +
                "yang mempunyai lima sisi dengan alasnya yang berbentuk segi empat dan sisi tegaknya berbentuk segitiga.\n\n" +
                "Ciri ciri limas segi empat \n" +
                "1. Alasnya berbentuk segiempat.\n" +
                "2. Mempunyai lima buah bidang sisi.\n" +
                "3. Memiliki lima buah titik sudut.\n" +
                "4. Mempunyai delapan buah rusuk.\n\n" +
                "Luas (L) = Luas alas + 4 X Luas sisi\n" +
                "\n" +
                "Dimana kita tahu :" +
                "\n" +
                "Luas alas limas = sisi×sisi" +
                "\n" +
                "Luas sisi tegak segitiga = (½×alas×tinggi)×4.");

        SClplimasempat.postDelayed(new Runnable() {
            @Override
            public void run() {
                SClplimasempat.fullScroll(View.FOCUS_UP);
            }
        },10);

        BTHitung = (Button) findViewById(R.id.bt_hitung_lp_limasempat);
        BTHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //L = LA x LS

                try{

                    final Dialog dialog = new Dialog(LPLimasSegiEmpat.this);
                    dialog.setContentView(R.layout.pop);
                    dialog.setTitle("Hasil");

                    ETluasalas = (EditText) findViewById(R.id.et_LA_limasSegiEmpat);
                    ETluasselimut =  (EditText) findViewById(R.id.et_LS_limasSegiEmpat);

                    mluasselimut = Integer.parseInt(ETluasselimut.getText().toString());
                    mLuasalas = Integer.parseInt(ETluasalas.getText().toString());

                    mJawabanLimas = mluasselimut * mLuasalas;

                    TextView TVJawabanLimas = (TextView) dialog.findViewById(R.id.tv_hasil);
                    TVJawabanLimas.setText("Hasil\n\n" + Integer.toString(mJawabanLimas) + " cm");

                    dialog.show();
                }catch (Exception e){
                    Toast.makeText(LPLimasSegiEmpat.this  ,"Kolom input tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
