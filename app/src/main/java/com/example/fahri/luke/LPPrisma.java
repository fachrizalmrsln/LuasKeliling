package com.example.fahri.luke;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class LPPrisma extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText ETLA;
    private EditText ETLS;
    private TextView TVPenjelasan;
    private ScrollView SClppirmsa;
    private Integer mLA;
    private Integer mLS;
    private Integer mJawaban;
    private Button BTHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lpprisma);

        toolbar = (Toolbar) findViewById(R.id.toolbar_lpprisma);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TVPenjelasan = (TextView) findViewById(R.id.tv_penjelasan_rumus_lp_prisma);
        SClppirmsa = (ScrollView) findViewById(R.id.scroll_lpprisma);

        TVPenjelasan.setText("Prisma adalah suatu bangun ruang yang memiliki alas bawah atau " +
                "tutup bawah dan tutup atas sama besar atau kongren, " +
                "dan sisi tegak atau sisi bagian samping berbentuk persegi panjang.\n" +
                "Sebenernya prisma itu banyak jenisnya, mulai dari prisma segitiga, segi empat, dan yang lainnya. " +
                "Seperti halnya prisma segi empat, prisma segi empat biasa kita sebut balok.\n" +
                "\nRumus Luas Permukaan Prisma adalah Luas seluruh perumakaan prisma. " +
                "Karena ini Prisma Segitiga, maka luas permukaannya adalah \n\nLuas 2 segitiga (atas dan bawah) + 3 luas persegi panjang. " +
                "Maka apa bila kita gambarkan secara logis :\n\n" +
                "Luas Permukaan Prisma Segitiga (L) = 2 x Luas alas x Luas selimut.");

        SClppirmsa.postDelayed(new Runnable() {
            @Override
            public void run() {
                SClppirmsa.fullScroll(ViewGroup.FOCUS_UP);
            }
        },10);

        BTHitung = (Button) findViewById(R.id.bt_hitung_lp_prisma);
        BTHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{

                    final Dialog dialog = new Dialog(LPPrisma.this);
                    dialog.setContentView(R.layout.pop);
                    dialog.setTitle("Hasil");

                    ETLA = (EditText) findViewById(R.id.et_LAlp_prisma);
                    ETLS = (EditText) findViewById(R.id.et_LSlp_prisma);

                    mLA = Integer.parseInt(ETLA.getText().toString());
                    mLS = Integer.parseInt(ETLS.getText().toString());

                    //L = 2 x la x ls

                    mJawaban = 2 * mLA * mLS;

                    TextView TVJawaban = (TextView) dialog.findViewById(R.id.tv_hasil);
                    TVJawaban.setText("Hasil\n\n" + Integer.toString(mJawaban) + " cm");

                    dialog.show();

                }catch (Exception e){
                    Toast.makeText(LPPrisma.this , "Kolom input tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
