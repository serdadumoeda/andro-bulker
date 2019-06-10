package com.datin.bulker.hi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.datin.bulker.R;
import com.datin.bulker.hi.HiItem;

public class DetailHi extends AppCompatActivity {

    public static String EXTRA_PLAYER = "extra_player";
    TextView tvNo, tvNama;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hi);

        tvNo = findViewById(R.id.tvNo);
        tvNama = findViewById(R.id.tvNama);


        HiItem HiItem =  getIntent().getParcelableExtra(EXTRA_PLAYER);

        String no = HiItem.getJudul();
        String name = HiItem.getDeskripsi();

        tvNo.setText(no);
        tvNama.setText(name);


    }
}
