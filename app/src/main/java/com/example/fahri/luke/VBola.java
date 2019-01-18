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

public class VBola extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText ETJariBola;
    private TextView TVPenjelasan;
    private ScrollView SCvbola;
    private Integer mJariVBola;
    private Double mJawabanVBola;
    private Button BTHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vbola);

        toolbar = (Toolbar) findViewById(R.id.toolbar_vbola);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TVPenjelasan = (TextView) findViewById(R.id.tv_penjelasan_rumus_volume_bola);
        SCvbola = (ScrollView) findViewById(R.id.scroll_vbola);

        TVPenjelasan.setText("Bola adalah benda geometri tiga dimensi yang bulat sempurna, dengan semua titik yang berada " +
                "di permukaan bola memiliki jarak yang sama dari pusatnya. \n\nBanyak benda-benda yang sering digunakan, seperti " +
                "bola atau globe, merupakan bola. Jika Anda ingin menghitung volume sebuah bola, " +
                "Anda hanya perlu mencari jari-jarinya dan memasukkannya ke dalam persamaan sederhana.\n\nV = ⁴⁄₃πr³.");

        SCvbola.postDelayed(new Runnable() {
            @Override
            public void run() {
                SCvbola.fullScroll(View.FOCUS_UP);
            }
        },10);

        BTHitung = (Button) findViewById(R.id.bt_hitung_v_bola);
        BTHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //V = 4/3 x pi x r x r x r

                try {

                    final Dialog dialog = new Dialog(VBola.this);
                    dialog.setContentView(R.layout.pop);
                    dialog.setTitle("Hasil");

                    ETJariBola = (EditText) findViewById(R.id.et_jari_vbola);
                    mJariVBola = Integer.parseInt(ETJariBola.getText().toString());

                    mJawabanVBola = 4/3 * 3.14 * mJariVBola * mJariVBola * mJariVBola;

                    TextView TVJawabanBola = (TextView) dialog.findViewById(R.id.tv_hasil);
                    TVJawabanBola.setText("Hasil\n\n" + Double.toString(mJawabanVBola) + " cm");

                    dialog.show();

                }catch (Exception e){
                    Toast.makeText(VBola.this, "Kolom input tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
