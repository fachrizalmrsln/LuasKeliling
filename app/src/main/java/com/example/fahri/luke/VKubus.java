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

public class VKubus extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText ETSisiKubus;
    private Integer mSisiKubus;
    private Integer mJawabanKubus;
    private TextView TVPenjelasan;
    private ScrollView SCvkubus;
    private Button BTHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vkubus);

        toolbar = (Toolbar) findViewById(R.id.toolbar_vkubus);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TVPenjelasan = (TextView) findViewById(R.id.tv_penjelasan_rumus_volume_kubus);
        SCvkubus = (ScrollView) findViewById(R.id.scroll_vkubus);

        TVPenjelasan.setText("Untuk menghitung volume sebuah kubus, kamu harus mengetahui panjang rusuk atau sisi kubus tersebut.\n" +
                "Rumus untuk mencari volume kubus adalah \nVolume = sisi x sisi x sisi. \n\nRumus ini bisa ditulis sebagai berikut.\n" +
                "\n" +
                "Rumus Volume Kubus: \n\nV = sisi x sisi x sisi atau \n\nV = S x S x S.");

        SCvkubus.postDelayed(new Runnable() {
            @Override
            public void run() {
                SCvkubus.fullScroll(View.FOCUS_UP);
            }
        },10);

        BTHitung = (Button) findViewById(R.id.bt_hitung_v_kubus);
        BTHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //V = s x s x s

                try{

                    final Dialog dialog = new Dialog(VKubus.this);
                    dialog.setContentView(R.layout.pop);
                    dialog.setTitle("Hasil");

                    ETSisiKubus = (EditText) findViewById(R.id.et_sisiv_kubus);
                    mSisiKubus = Integer.parseInt(ETSisiKubus.getText().toString());

                    mJawabanKubus =  mSisiKubus * mSisiKubus * mSisiKubus;
                    TextView TVJawabanKubus = (TextView) dialog.findViewById(R.id.tv_hasil);
                    TVJawabanKubus.setText("Hasil\n\n" + Integer.toString(mJawabanKubus) + " cm");

                    dialog.show();

                }catch (Exception e){
                    Toast.makeText(VKubus.this  , "Kolom input tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}
