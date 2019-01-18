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

public class LPKerucut extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText ETJariKerucut;
    private EditText ETPanjangKerucut;
    private TextView TVPenjelasan;
    private Integer mJariKerucut;
    private Integer mPanjangKerucut;
    private Double mJawabanKerucut;
    private ScrollView SClpkerucut;
    private Button BTHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lpkerucut);

        toolbar = (Toolbar) findViewById(R.id.toolbar_lpkerucut);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TVPenjelasan = (TextView) findViewById(R.id.tv_penjelasan_rumus_lp_kerucut);
        SClpkerucut = (ScrollView) findViewById(R.id.scroll_lpkerucut);

        TVPenjelasan.setText("Permukaan kerucut merupakan gabungan dari selimut kerucut dan alas kerucut. " +
                "Alas kerucut adalah bidang lingkaran dengan jari-jari r sehingga luas alas adalah π.r2.\n\n" +
                "Jika selimut kerucut kita bentangkan maka bentuknya adalah bidang juring (sektor) " +
                "lingkaran dengan busur sama dengan keliling lingkaran alas yaitu 2.π.r. Kalau kita perhatikan " +
                "bidang juring ini merupakan potongan dari lingkaran besar dengan jari-jari s. " +
                "Lingkaran besar ini jika utuh kelilingnya 2.π.s dan luasnya π.s2.\n" +
                "Luas permukaan kerucut = Luas alas + Luas selimut\n\n" +
                "Luas permukaan kerucut = π.r2 + π.r.s\n" +
                "Luas permukaan kerucut = π.r (r + s).");

        SClpkerucut.postDelayed(new Runnable() {
            @Override
            public void run() {
                SClpkerucut.fullScroll(View.FOCUS_UP);
            }
        }, 10);

        BTHitung = (Button) findViewById(R.id.bt_hitung_lp_kerucut);
        BTHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //L = pi x r x (r + s)

                try{

                    final Dialog dialog = new Dialog(LPKerucut.this);
                    dialog.setContentView(R.layout.pop);
                    dialog.setTitle("Hasil");

                    ETJariKerucut = (EditText) findViewById(R.id.et_jarilp_kerucut);
                    ETPanjangKerucut = (EditText) findViewById(R.id.et_panjang_kerucut);

                    mJariKerucut = Integer.parseInt(ETJariKerucut.getText().toString());
                    mPanjangKerucut = Integer.parseInt(ETPanjangKerucut.getText().toString());

                    mJawabanKerucut = 3.14 * mJariKerucut * (mJariKerucut  + mPanjangKerucut);

                    TextView TVJawabanKerucut  = (TextView) dialog.findViewById(R.id.tv_hasil);
                    TVJawabanKerucut.setText("Hasil\n\n" + Double.toString(mJawabanKerucut) + " cm");

                    dialog.show();
                }catch (Exception e){
                    Toast.makeText(LPKerucut.this , "Kolom input tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
