package com.datin.bulker.penta.ptkdn;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.datin.bulker.R;
import com.datin.bulker.penta.DetailPasarKerja;
import com.datin.bulker.penta.PasarKerjaItem;
import com.datin.bulker.penta.PentaTenagaKerjaAsing;
import com.datin.bulker.penta.ptkdn.PtkdnItem;


public class DetailPtkdn extends AppCompatActivity {

    public static String EXTRA_PLAYER = "extra_player";
    TextView tvJudul, tvDeskripsi, tvTahun, tvTanggal;

    public void lihat(View view){
        Intent intent= new Intent();
        intent.setClass(DetailPtkdn.this, PentaTenagaKerjaAsing.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ptkdn);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.judul);
        collapsingToolbarLayout.setTitleEnabled(true);

        tvJudul = findViewById(R.id.tvJudul);
        tvTahun = findViewById(R.id.tvTahun);
        tvTanggal = findViewById(R.id.tvTanggal);
        tvDeskripsi = findViewById(R.id.tvDeskripsi);
        ImageView imgVIew = findViewById(R.id.imgView);


        PtkdnItem PtkdnItem =  getIntent().getParcelableExtra(EXTRA_PLAYER);

        String judul = PtkdnItem.getJudul();
        String tahun = PtkdnItem.getTh_id();
        String tanggal = PtkdnItem.getCreated_at();
        String deskripsi = PtkdnItem.getDeskripsi();

        tvJudul.setText(judul);
        collapsingToolbarLayout.setTitle(judul);
        tvDeskripsi.setText(Html.fromHtml(deskripsi));
        tvTanggal.setText(tanggal);
        tvTahun.setText(tahun);
        Glide.with(this).load("https://buletinnaker.kemnaker.go.id/storage/coverpenta/"+ PtkdnItem.getFile()).into(imgVIew);


    }
}
