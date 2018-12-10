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

public class LPTabung extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText ETTinggi;
    private EditText ETJari;
    private TextView TVPenjelasan;
    private ScrollView SClptabung;
    private Integer mTinggi;
    private Integer mJari;
    private Double mJawaban;
    private Button BTHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lptabung);

        toolbar = (Toolbar) findViewById(R.id.toolbar_lptabung);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TVPenjelasan = (TextView) findViewById(R.id.tv_penjelasan_rumus_lp_tabung);

        SClptabung = (ScrollView) findViewById(R.id.scroll_lptabung);

        TVPenjelasan.setText("Rumus luas permukaan tabung -Tabung adalah bangun ruang yang diatasi oleh dua sisi yang kongruen dan sejajar yang berbentuk lingkaran serta sebuah sisi lengkung.\n" +
                "\n" +
                "Ciri  Ciri Tabung\n" +
                "\n" +
                "Mempunyai 2 rusuk\n" +
                "Alas dan tutusnya berupa lingkaran\n" +
                "Mempunyai 3 bidang sisi (bidang alas, bidang selimut dan bidang tutup)\n" +
                "Keterangan Rumus luas permukaan tabung\n" +
                "\n" +
                "r = jari-jari tutup/alas tabung\n" +
                "t= tinggi tabung.");

        SClptabung.postDelayed(new Runnable() {
            @Override
            public void run() {
                SClptabung.fullScroll(View.FOCUS_UP);
            }
        },10);

        BTHitung = (Button) findViewById(R.id.bt_hitung_lp_tabung);
        BTHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //L =  2 x pi x r x (r + t)

                try {

                    final Dialog dialog = new Dialog(LPTabung.this);
                    dialog.setContentView(R.layout.pop);
                    dialog.setTitle("Hasil");

                    ETTinggi = (EditText) findViewById(R.id.et_Tinggilp_tabung);
                    ETJari = (EditText) findViewById(R.id.et_jarilp_tabung);

                    mJari = Integer.parseInt(ETJari.getText().toString());
                    mTinggi = Integer.parseInt(ETTinggi.getText().toString());

                    mJawaban  = 2 * 3.14 * mJari * (mJari + mTinggi);

                    TextView TVJawaban = (TextView) dialog.findViewById(R.id.tv_hasil);
                    TVJawaban.setText("Hasil\n\n" + Double.toString(mJawaban) + " cm");

                    dialog.show();

                }catch (Exception e){
                    Toast.makeText(LPTabung.this , "Kolom input tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
