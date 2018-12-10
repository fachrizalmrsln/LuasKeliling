package com.example.fahri.luke;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class LPLimasSegiTiga extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText ETAlas;
    private EditText ETTinggi;
    private ScrollView SClplimastiga;
    private TextView TVPenjelasan;
    private Integer mAlas;
    private Integer mTinggi;
    private Double mJawaban;
    private Button BTHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lplimas_segi_tiga);

        toolbar = (Toolbar) findViewById(R.id.toolbar_lplimas_segi_tiga);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TVPenjelasan = (TextView) findViewById(R.id.tv_penjelasan_rumus_lp_limasSegiTiga);
        SClplimastiga = (ScrollView) findViewById(R.id.scroll_lplimastiga);

        TVPenjelasan.setText("Limas segitiga merupakan " +
                "limas yang memilik alas yang berbentuk segitiga, baik itu segitiga sama kaki, " +
                "segitiga sembarang, segitiga siku-siku, ataupun segitiga sama sisi.\n\n" +
                "Ciri ciri limas segitiga \n" +
                "1. Mempunyai alas yang berbentuk segitiga.\n" +
                "2. Memiliki empat buah bidang sisi yaitu alas dan tiga buah sisi tegak.\n" +
                "3. Mempunyai enam buah rusuk.\n" +
                "4. Memiliki empat buah titik sudut.\n\n" +
                "Rumus luas alas limas = 1/2 x a x t\n" +
                "\n" +
                "Rumus luas permukaan limas = luas alas +  jumlah luas seluruh sisi tegak.");

        SClplimastiga.postDelayed(new Runnable() {
            @Override
            public void run() {
                SClplimastiga.fullScroll(View.FOCUS_UP);
            }
        },10);

        BTHitung = (Button) findViewById(R.id.bt_hitung_lp_limastiga);
        BTHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //L = 1/2 a x t

                try{

                    final Dialog dialog = new Dialog(LPLimasSegiTiga.this);
                    dialog.setContentView(R.layout.pop);
                    dialog.setTitle("Hasil");

                    ETAlas = (EditText) findViewById(R.id.et_Alas_limasSegiTiga);
                    ETTinggi = (EditText) findViewById(R.id.et_Tinggi_limasSegiTiga);

                    mAlas = Integer.parseInt(ETAlas.getText().toString());
                    mTinggi = Integer.parseInt(ETTinggi.getText().toString());

                    mJawaban = 0.5 * mAlas * mTinggi;

                    TextView TVJawaban =  (TextView) dialog.findViewById(R.id.tv_hasil);
                    TVJawaban.setText("Hasil\n\n" + Double.toString(mJawaban) + " cm");

                    dialog.show();

                }catch (Exception e){
                    Toast.makeText(LPLimasSegiTiga.this, "Kolom input tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
