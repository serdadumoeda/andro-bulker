package com.datin.bulker.penta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.datin.bulker.R;

public class DetailPasarKerja extends AppCompatActivity {

    public static String EXTRA_PLAYER = "extra_player";
    TextView tvNo, tvNama;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pasar_kerja);

        tvNo = findViewById(R.id.tvNo);
        tvNama = findViewById(R.id.tvNama);


        PasarKerjaItem PasarKerjaItem =  getIntent().getParcelableExtra(EXTRA_PLAYER);

        String no = PasarKerjaItem.getNo();
        String name = PasarKerjaItem.getName();

        tvNo.setText(no);
        tvNama.setText(name);


    }
}
