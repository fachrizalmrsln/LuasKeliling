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

public class LPKubus extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText ETSisiKubus;
    private TextView TVPenjelasan;
    private Integer mSisiKubus;
    private Integer mJawabanKubus;
    private ScrollView SClpkubus;
    private Button BTHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lpkubus);

        toolbar = (Toolbar) findViewById(R.id.toolbar_lpkubus);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TVPenjelasan = (TextView) findViewById(R.id.tv_penjelasan_rumus_lp_kubus);
        SClpkubus  = (ScrollView) findViewById(R.id.scroll_lpkubus);

        TVPenjelasan.setText("Pahami bahwa luas permukaan kubus terdiri dari luas keenam wajah kubus. Karena semua wajah kubus sebangun, " +
                "kita bisa mencari area satu wajah dan mengalikan dengan 6 untuk mendapatkan total luas permukaan. " +
                "Luas permukaan dapat ditemukan dengan menggunakan rumus sederhana: 6xs2, \"s\" merupakan sisi kubus.\n\n" +
                "Temukan luas satu sisi kubus. Untuk mencari luas satu sisi kubus, carilah \"s\" " +
                "yang merupakan panjang sisi kubus, lalu cari s2. Artinya kita akan mengalikan panjang sisi kubus dengan " +
                "lebar untuk mencari luasnya. Panjang dan lebar sisi kubus kebetulan sama. Jika salah satu sisi kubus atau \"s\" " +
                "adalah 4 cm, maka luas sisi kubus adalah (4 cm)2, atau 16 cm2. " +
                "Ingatlah untuk menyatakan jawaban dalam satuan persegi.\n\n" +
                "Kalikan luas sisi kubus dengan 6. Kita telah mengetahui luas satu sisi kubus, " +
                "dan sekarang kita akan mencari luas permukaan dengan mengalikan jumlah ini dengan 6. 16 cm2x6 = 96 cm2.");

        SClpkubus.postDelayed(new Runnable() {
            @Override
            public void run() {
              SClpkubus.fullScroll(View.FOCUS_UP);
            }
        },10);

        BTHitung = (Button) findViewById(R.id.bt_hitung_lp_kubus);
        BTHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //L = 6 x s x s

                try{

                    final Dialog dialog = new Dialog(LPKubus.this);
                    dialog.setContentView(R.layout.pop);
                    dialog.setTitle("Hasil");

                    ETSisiKubus = (EditText) findViewById(R.id.et_sisi_kubus);

                    mSisiKubus = Integer.parseInt(ETSisiKubus.getText().toString());

                    mJawabanKubus =  6 * mSisiKubus * mSisiKubus;

                    TextView TVJawabanKubus = (TextView) dialog.findViewById(R.id.tv_hasil);
                    TVJawabanKubus.setText("Hasil\n\n" + Integer.toString(mJawabanKubus) + " cm");

                    dialog.show();
                }catch (Exception e){
                    Toast.makeText(LPKubus.this , "Kolom input tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
