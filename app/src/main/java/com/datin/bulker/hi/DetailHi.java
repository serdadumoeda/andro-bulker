package com.datin.bulker.hi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import com.datin.bulker.R;
import com.datin.bulker.hi.HiItem;

public class DetailHi extends AppCompatActivity {

    public static String EXTRA_PLAYER = "extra_player";
    TextView tvJudul, tvDeskripsi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hi);

        tvJudul = findViewById(R.id.tvJudul);
        tvDeskripsi = findViewById(R.id.tvDeskripsi);


        HiItem HiItem =  getIntent().getParcelableExtra(EXTRA_PLAYER);

        String judul = HiItem.getJudul();
        String deskripsi = HiItem.getDeskripsi();

        tvJudul.setText(judul);
        tvDeskripsi.setText(Html.fromHtml(deskripsi));


    }
}
