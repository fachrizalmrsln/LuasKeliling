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

public class VKerucut extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText ETJariVKerucut;
    private EditText ETTinggiVKerucut;
    private TextView TVPenjelasan;
    private ScrollView SCvkerucut;
    private Integer mJariVKerucut;
    private Integer mTinggiVKerucut;
    private Double mJawabanVKerucut;
    private Button BTHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vkerucut);

        toolbar = (Toolbar) findViewById(R.id.toolbar_vkerucut);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TVPenjelasan = (TextView) findViewById(R.id.tv_penjelasan_rumus_volume_kerucut);
        SCvkerucut = (ScrollView) findViewById(R.id.scroll_vkerucut);

        TVPenjelasan.setText("Volume kerucut atau isi kerucut adalah ruang tiga dimensi yang terdapat di dalam kerucut. " +
                "Misalnya sebuah kerucut yang terbuat dari beton pejal memiliki volume satu meter kubik maka jumlah volume beton yang " +
                "mengisi ruang dalam kerucut tersebut adalah 1 meter kubik.\n\n" +
                "Untuk menghitung volume sebuah kerucut maka harus diketahui dimensi radius " +
                "(atau diameter alas) dan tinggi kerucut tersebut .  Volume sebuah kerucut dengan jari-jari r dan tinggi t " +
                "dapat dihitung dengan menggunakan rumus berikut.\n\n" +
                "V = 1/3 pi x  r x r x t.");

        SCvkerucut.postDelayed(new Runnable() {
            @Override
            public void run() {
                SCvkerucut.fullScroll(View.FOCUS_UP);
            }
        },10);

        BTHitung = (Button) findViewById(R.id.bt_hitung_v_kerucut);
        BTHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //V = 1/3 x pi x r x r x t

                try{

                    final Dialog dialog = new Dialog(VKerucut.this);
                    dialog.setContentView(R.layout.pop);
                    dialog.setTitle("Hasil");

                    ETJariVKerucut = (EditText) findViewById(R.id.et_jari_kerucut);
                    ETTinggiVKerucut = (EditText) findViewById(R.id.et_tinggi_kerucut);

                    mJariVKerucut = Integer.parseInt(ETJariVKerucut.getText().toString());
                    mTinggiVKerucut = Integer.parseInt(ETTinggiVKerucut.getText().toString());

                    mJawabanVKerucut = 0.33 * 3.14 * mJariVKerucut * mJariVKerucut * mTinggiVKerucut;
                    TextView TVJawabanVKerucut = (TextView) dialog.findViewById(R.id.tv_hasil);
                    TVJawabanVKerucut.setText("Hasil\n\n" + Double.toString(mJawabanVKerucut) + " cm");

                    dialog.show();

                }catch (Exception e){
                    Toast.makeText(VKerucut.this, "Kolom input tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}
