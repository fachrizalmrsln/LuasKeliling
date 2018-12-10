package com.example.fahri.luke;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.style.EasyEditSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class VPrisma extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText ETLA;
    private EditText ETTinggi;
    private TextView TVPenjelasan;
    private ScrollView SCvprimsa;
    private Integer mLA;
    private Integer mTinggi;
    private Integer mJawaban;
    private Button BTHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vprisma);

        toolbar = (Toolbar) findViewById(R.id.toolbar_vprisma);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TVPenjelasan = (TextView) findViewById(R.id.tv_penjelasan_rumus_volume_prisma);
        SCvprimsa = (ScrollView) findViewById(R.id.scroll_vprisma);

        TVPenjelasan.setText("Kita ketahui bahwa balok merupakan salah satu contoh prisma tegak segi empat. " +
                "Untuk menentukan rumus volume prisma, dapat menggunakan analogi setengah volume balok.\n\n" +
                "Dalam hal ini luas alas prisma tersebut berbentuk segitiga siku-siku dengan luas alas yakni:\n" +
                "Luas alas = ½ × p × l\n" +
                "Maka volume prisma tegak segitiga siku-siku di atas dapat dirumuskan sebagai berikut:\n" +
                "V. prisma BCD.FGH = luas alas × tinggi\n" +
                "\n" +
                "Jadi, volume prisma secara umum dapat dirumuskan sebagai berikut, yakni:\n" +
                "Volume = luas alas × tinggi\n" +
                "atau\n" +
                "V = La x t.");

        SCvprimsa.postDelayed(new Runnable() {
            @Override
            public void run() {
                SCvprimsa.fullScroll(View.FOCUS_UP);
            }
        },10);

        BTHitung = (Button) findViewById(R.id.bt_hitung_v_prisma);
        BTHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // V = LA * T

                try{

                    final Dialog dialog = new Dialog(VPrisma.this);
                    dialog.setContentView(R.layout.pop);
                    dialog.setTitle("Hasil");

                    ETLA = (EditText) findViewById(R.id.et_LA_prisma);
                    ETTinggi = (EditText) findViewById(R.id.et_Tinggi_prisma);

                    mLA = Integer.parseInt(ETLA.getText().toString());
                    mTinggi = Integer.parseInt(ETTinggi.getText().toString());

                    mJawaban = mLA * mTinggi;
                    TextView TVJawaban = (TextView) dialog.findViewById(R.id.tv_hasil);
                    TVJawaban.setText("Hasil\n\n" + Integer.toString(mJawaban) + " cm");

                    dialog.show();

                }catch (Exception e){
                    Toast.makeText(VPrisma.this, "Kolom input tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
