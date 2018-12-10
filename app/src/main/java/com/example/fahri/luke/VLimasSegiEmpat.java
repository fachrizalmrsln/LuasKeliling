package com.example.fahri.luke;

import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.RestrictTo;
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

public class VLimasSegiEmpat extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText ETPanjangLimasEmpat;
    private EditText ETLebarLimasEmpat;
    private EditText ETTinggiLimasEmpat;
    private TextView TVPenjelasan;
    private ScrollView SCvlimasempat;
    private Integer mPanjangLimasEmpat;
    private Integer mLebarLimasEmpat;
    private Integer mTinggiLimasEmpat;
    private Double mJawabanLimasEmpat;
    private Button BTHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlimas_segi_empat);

        toolbar = (Toolbar) findViewById(R.id.toolbar_vlimas_segi_empat);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TVPenjelasan =  (TextView) findViewById(R.id.tv_penjelasan_rumus_volume_limasSegiEmpat);
        SCvlimasempat = (ScrollView) findViewById(R.id.scroll_vlimasempat);

        TVPenjelasan.setText("Untuk menentukan rumus volume limas, dapat dicari dengan bantuan sebuah kubus.\n\n" +
                "Jika kita membuat semua diagonal ruangnya maka diagonal-diagonal tersebut akan berpotongan pada satu " +
                "titik dan membagi kubus ABCD.EFGH menjadi enam limas segiempat yang kongruen. Dapatkah kamu menyebutkan " +
                "nama dari keenam limas tersebut?\n" +
                "\n" +
                "Dari uraian di atas dapat diperoleh bahwa luas enam limas segiempat sama dengan luas kubus. Dengan demikian:\n\n" +
                "Volume = 1/3 x P x L x T");

        SCvlimasempat.postDelayed(new Runnable() {
            @Override
            public void run() {
                SCvlimasempat.fullScroll(View.FOCUS_UP);
            }
        },10);

        BTHitung = (Button) findViewById(R.id.bt_hitung_v_limasempat);
        BTHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //V = 1/3 x p x l x t

                try{

                    final Dialog dialog = new Dialog(VLimasSegiEmpat.this);
                    dialog.setContentView(R.layout.pop);
                    dialog.setTitle("Hasil");

                    ETPanjangLimasEmpat = (EditText) findViewById(R.id.et_panjangv_limasSegiEmpat);
                    ETLebarLimasEmpat = (EditText) findViewById(R.id.et_lebarv_limasSegiEmpat);
                    ETTinggiLimasEmpat = (EditText) findViewById(R.id.et_tinggiv_limasSegiEmpat);

                    mPanjangLimasEmpat = Integer.parseInt(ETPanjangLimasEmpat.getText().toString());
                    mLebarLimasEmpat = Integer.parseInt(ETLebarLimasEmpat.getText().toString());
                    mTinggiLimasEmpat = Integer.parseInt(ETTinggiLimasEmpat.getText().toString());

                    mJawabanLimasEmpat = 0.33 * mPanjangLimasEmpat * mLebarLimasEmpat * mTinggiLimasEmpat;
                    TextView TVJawabanLimasEmpat =  (TextView) dialog.findViewById(R.id.tv_hasil);
                    TVJawabanLimasEmpat.setText("Hasil\n\n" + Double.toString(mJawabanLimasEmpat) + " cm");

                    dialog.show();

                }catch (Exception e){
                    Toast.makeText(VLimasSegiEmpat.this, "Kolom input tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void bt_hitung_volume_limasSegiEmpat (View  view) {


        if (mPanjangLimasEmpat == 0) {
            Toast.makeText(VLimasSegiEmpat.this, "Kolom Panjang Limas tidak boleh kosong !", Toast.LENGTH_SHORT).show();
            return;
        } else if (mLebarLimasEmpat == 0) {
            Toast.makeText(VLimasSegiEmpat.this, "Kolom Lebar Limas tidak boleh kosong !", Toast.LENGTH_SHORT).show();
            return;
        } else if (mTinggiLimasEmpat == 0) {
            Toast.makeText(VLimasSegiEmpat.this, "Kolom Tinggi Limas tidak boleh kosong !", Toast.LENGTH_SHORT).show();
            return;
        } else {





        }
    }


}
