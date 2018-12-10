package com.example.fahri.luke;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class LPBola extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText ETJariBola;
    private TextView TVPenjelasan;
    private Integer mJariBola;
    private Double mJawabanBola;
    private ScrollView SClpbola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lpbola);

        toolbar = (Toolbar) findViewById(R.id.toolbar_lpbola);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TVPenjelasan = (TextView) findViewById(R.id.tv_penjelasan_rumus_lp_bola);
        SClpbola = (ScrollView) findViewById(R.id.scroll_lpbola);

        TVPenjelasan.setText("Bola merupakan sebuah bangun ruang di mana permukaannya memiliki jarak yang sama terhadap titik pusatnya.\nBangun ruang bola mempunyai ciri-ciri :\n" +
                "\n" +
                "1. hanya memiliki satu buah bidang sisi.\n" +
                "2. tidak memiliki sudut dan juga tidak memiliki rusuk.\n\nV = 4/3 x π x r³\n" +
                "\n" +
                "Keterangan :\n" +
                "V = volume bola.\n" +
                "r  = jari-jari bola.\n" +
                "π = 22/7 atau 3,14.");

        SClpbola.postDelayed(new Runnable() {
            @Override
            public void run() {
                SClpbola.fullScroll(View.FOCUS_UP);
            }
        }, 10);

        Button BTHitung = (Button) findViewById(R.id.bt_hitung_lp_bola);
        BTHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //L = 4 x pi x r x r

                try {

                    final Dialog dialog = new Dialog(LPBola.this);
                    dialog.setContentView(R.layout.pop);
                    dialog.setTitle("Hasil");

                    ETJariBola = (EditText) findViewById(R.id.et_jarilp_bola);

                    mJariBola = Integer.parseInt(ETJariBola.getText().toString());

                    mJawabanBola = 4 * 3.14 * mJariBola * mJariBola;

                    TextView TVJawabanBola = (TextView) dialog.findViewById(R.id.tv_hasil);
                    TVJawabanBola.setText("Hasil\n\n" + Double.toString(mJawabanBola) + " cm");

                    dialog.show();
                }catch (Exception e){
                    Toast.makeText(LPBola.this, "Kolom input tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
