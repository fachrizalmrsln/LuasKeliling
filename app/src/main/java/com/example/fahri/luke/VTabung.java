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

public class VTabung extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText ETJari;
    private EditText ETTinggi;
    private TextView TVPenjelasan;
    private ScrollView SCvtabung;
    private Integer mJari;
    private Integer mTinggi;
    private Double mJawaban;
    private Button BTHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vtabung);

        toolbar = (Toolbar) findViewById(R.id.toolbar_vtabung);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TVPenjelasan = (TextView) findViewById(R.id.tv_penjelasan_rumus_volume_tabung);
        SCvtabung = (ScrollView) findViewById(R.id.scroll_vtabung);

        TVPenjelasan.setText("Rumus ini seringkali ditulis secara lebih disingkat sebagai V = phi x r x r x t. " +
                "Volume sebuah silinder pada dasarnya adalah luas lingkaran penampang tabung dikalikan dengan tinggi tabung. " +
                "Pada rumus tersebut pi x r x r adalah luas lingkaran penampang silinder.\n" +
                "\n" +
                "Perlu diperhatikan bahwa dalam menghitung volume sebuah silinder menggunakan rumus di atas, " +
                "dimensi radius (atau diameter) dan tingginya harus dalam satuan yang sama. Satuan volume adalah satuan" +
                " panjang kubik misalnya millimeter kubik (mm³), centimeter kubik (cm³) , meter kubik (m³), dan lain sebagainya.");

        SCvtabung.postDelayed(new Runnable() {
            @Override
            public void run() {
                SCvtabung.fullScroll(View.FOCUS_UP);
            }
        },10);

        BTHitung = (Button) findViewById(R.id.bt_hitung_v_tabung);
        BTHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //V = pi x r x r x t

                try{

                    final Dialog dialog = new Dialog(VTabung.this);
                    dialog.setContentView(R.layout.pop);
                    dialog.setTitle("Hasil");

                    ETJari  = (EditText) findViewById(R.id.et_jari_tabung);
                    ETTinggi = (EditText) findViewById(R.id.et_Tinggi_tabung);

                    mJari = Integer.parseInt(ETJari.getText().toString());
                    mTinggi = Integer.parseInt(ETTinggi.getText().toString());

                    mJawaban = 3.14 * mJari * mJari * mTinggi;
                    TextView TVJawaban = (TextView) dialog.findViewById(R.id.tv_hasil);
                    TVJawaban.setText("Hasil\n\n" + Double.toString(mJawaban) + " cm");

                    dialog.show();

                }catch (Exception e){
                    Toast.makeText(VTabung.this , "Kolom input tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
