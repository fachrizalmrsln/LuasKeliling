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

public class LPBalok extends AppCompatActivity {

    private Toolbar toolbar;

    private EditText ETPanjangBalok;
    private EditText ETLebarBalok;
    private EditText ETTinggiBalok;

    private TextView TVPenjelasan;

    private Integer mJawabanBalok;
    private Integer mPanjangBalok;
    private Integer mLebarBalok;
    private Integer mTinggiBalok;

    private Button BTHitung;

    private ScrollView SClpbalok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lpbalok);

        toolbar = (Toolbar) findViewById(R.id.toolbar_lpbalok);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TVPenjelasan = (TextView) findViewById(R.id.tv_penjelasan_rumus_lp_balok);
        SClpbalok = (ScrollView) findViewById(R.id.scroll_lpbalok);

        TVPenjelasan.setText("Luas permukaan balok adalah luas keseluruhan dari permukaan atau bidang sisi pada balok. " +
                "Balok memiliki enam buah sisi yaitu sisi atas, " +
                "sisi bawah, sisi kanan, sisi kiri, sisi depan dan sisi belakang. " +
                "Apabila sisi-sisi balok tersebut kita gambarkan mendatar maka akan terbentuk sebuah jaring-jaring balok. " +
                "Nah, luas dari jaring-jaring balok tersebutlah yang disebut sebagai luas permukaan balok.\n" +
                "Luas permukaan balok bisa kita ketahui dengan menggunakan rumus:\n" +
                "\n" +
                "Luas Permukaan balok = 2 (panjang x lebar) + 2 (panjang x tinggi) + 2 (lebar x tinggi)\n" +
                "Luas Permukaan balok = 2 pl + 2 pt + 2 lt\n" +
                "Luas Permukaan balok = 2 (pl + pt + lt).");

        SClpbalok.postDelayed(new Runnable() {
            @Override
            public void run() {
                SClpbalok.fullScroll(View.FOCUS_UP);
            }
        }, 10);

        BTHitung = (Button) findViewById(R.id.bt_hitung_lp_balok);
        BTHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //L = 2 (Pxl + Pxt + lXt)

                try {

                    final Dialog dialog = new Dialog(LPBalok.this);
                    dialog.setContentView(R.layout.pop);
                    dialog.setTitle("Hasil");

                    ETPanjangBalok = (EditText) findViewById(R.id.et_panjang_balok);
                    ETLebarBalok = (EditText) findViewById(R.id.et_lebar_balok);
                    ETTinggiBalok = (EditText) findViewById(R.id.et_tinggi_balok);

                    mPanjangBalok = Integer.parseInt(ETPanjangBalok.getText().toString());
                    mLebarBalok = Integer.parseInt(ETLebarBalok.getText().toString());
                    mTinggiBalok = Integer.parseInt(ETTinggiBalok.getText().toString());

                    mJawabanBalok = 2 * ((mPanjangBalok * mLebarBalok) + (mPanjangBalok * mTinggiBalok) + (mLebarBalok * mTinggiBalok));

                    TextView TVJawaban = (TextView) dialog.findViewById(R.id.tv_hasil);
                    TVJawaban.setText("Hasil\n\n" + Integer.toString(mJawabanBalok) + " cm");

                    dialog.show();
                } catch (Exception e) {
                    Toast.makeText(LPBalok.this, "Kolom input tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
