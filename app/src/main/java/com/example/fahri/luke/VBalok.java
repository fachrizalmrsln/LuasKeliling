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

public class VBalok extends AppCompatActivity {

    private Toolbar toolbar;

    private EditText ETPanjangBalok;
    private EditText ETLebarBalok;
    private EditText ETTinggiBalok;
    private TextView TVPenjelasan;
    private ScrollView SCvbalok;
    private Integer mPanjangvBalok;
    private Integer mLebarvBalok;
    private Integer mTinggivBalok;
    private Integer mJawabanVBalok;
    private Button BTHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vbalok);

        toolbar = (Toolbar) findViewById(R.id.toolbar_vbalok);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TVPenjelasan = (TextView) findViewById(R.id.tv_penjelasan_rumus_volume_balok);
        SCvbalok = (ScrollView) findViewById(R.id.scroll_vbalok);

        TVPenjelasan.setText("Untuk menghitung volume atau isi sebuah balok, yang " +
                "perlu diketahui adalah ukuran panjang, lebar, dan tinggi balok tersebut. " +
                "Untuk menghitung volume atau isi sebuah kotak, maka harus diketahui dimensi panjang, lebar, " +
                "dan tinggi kotak tersebut. Rumus untuk menghitung volume balok adalah:\n" +
                "\n" +
                "Volume balok = panjang x lebar x tinggi.");

        SCvbalok.postDelayed(new Runnable() {
            @Override
            public void run() {
                SCvbalok.fullScroll(View.FOCUS_UP);
            }
        },10);

        BTHitung = (Button) findViewById(R.id.bt_hitung_v_balok);
        BTHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //V = P x L x T

                try {

                    final Dialog dialog = new Dialog(VBalok.this);
                    dialog.setContentView(R.layout.pop);
                    dialog.setTitle("Hasil");

                    ETPanjangBalok = (EditText) findViewById(R.id.et_panjang_vbalok);
                    ETLebarBalok = (EditText) findViewById(R.id.et_lebar_vbalok);
                    ETTinggiBalok = (EditText) findViewById(R.id.et_tinggi_vbalok);

                    mPanjangvBalok = Integer.parseInt(ETPanjangBalok.getText().toString());
                    mLebarvBalok = Integer.parseInt(ETLebarBalok.getText().toString());
                    mTinggivBalok = Integer.parseInt(ETTinggiBalok.getText().toString());

                    mJawabanVBalok = mPanjangvBalok * mLebarvBalok * mTinggivBalok;

                    TextView TVJawabanBalok = (TextView) dialog.findViewById(R.id.tv_hasil);
                    TVJawabanBalok.setText("Hasil\n\n" + Integer.toString(mJawabanVBalok) + " cm");

                    dialog.show();

                }catch (Exception e){
                    Toast.makeText(VBalok.this , "Kolom input tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
