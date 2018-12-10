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

import org.w3c.dom.Text;

public class VLimasSegiTiga extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText ETPanjang;
    private EditText ETLebar;
    private TextView TVPenjelasan;
    private ScrollView SCvlimastiga;
    private Integer mPanjang;
    private Integer mLebar;
    private Double mJawaban;
    private Button BTHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlimas_segi_tiga);

        toolbar = (Toolbar) findViewById(R.id.toolbar_vlimas_segi_tiga);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TVPenjelasan = (TextView) findViewById(R.id.tv_penjelasan_rumus_volume_limasSegiTiga);
        SCvlimastiga = (ScrollView) findViewById(R.id.scroll_vlimastiga);

        TVPenjelasan.setText("Untuk mencari volume limas yang alasnya berbentuk segiempat dapat dilakukan dengan “mengalikan antara luas " +
                "alas dengan tinggi limas kemudian dibagi tiga” atau dapat dikatakan “sepertiga dari luas alas dikalikan dengan tinggi limas”.\n\n" +
                "Tidak hanya berlaku untuk volume limas segiempat saja, rumus tersebut juga berlaku untuk " +
                "volume limas yang alasnya berbetuk segitiga serta bentuk yang lainnya. \n\n" +
                "V = 1/3 × luas alas × tinggi.");

        SCvlimastiga.postDelayed(new Runnable() {
            @Override
            public void run() {
                SCvlimastiga.fullScroll(View.FOCUS_UP);
            }
        }, 10);

        BTHitung = (Button) findViewById(R.id.bt_hitung_v_limastiga);
        BTHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //V  = 1/3 (1/2 x p x l)

                try {

                    final Dialog dialog = new Dialog(VLimasSegiTiga.this);
                    dialog.setContentView(R.layout.pop);
                    dialog.setTitle("Hasil");

                    ETPanjang = (EditText) findViewById(R.id.et_Panjangv_limasSegiTiga);
                    ETLebar = (EditText) findViewById(R.id.et_Lebarv_limasSegiTiga);

                    mPanjang = Integer.parseInt(ETPanjang.getText().toString());
                    mLebar = Integer.parseInt(ETLebar.getText().toString());

                    mJawaban = 0.3 * (0.5 * mPanjang * mLebar);

                    TextView TVJawaban = (TextView) dialog.findViewById(R.id.tv_hasil);
                    TVJawaban.setText("Hasil\n\n" + Double.toString(mJawaban) + " cm");

                    dialog.show();

                } catch (Exception e) {
                    Toast.makeText(VLimasSegiTiga.this, "Kolom input tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}