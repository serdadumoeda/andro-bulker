package com.datin.bulker.penta;

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
import com.datin.bulker.penta.TenagaKerjaAsingItem;


public class DetailTenagaKerjaAsing extends AppCompatActivity {

    public static String EXTRA_PLAYER = "extra_player";
    TextView tvJudul, tvDeskripsi, tvTahun, tvTanggal;

    public void lihat(View view){
        Intent intent= new Intent();
        intent.setClass(DetailTenagaKerjaAsing.this, PentaTenagaKerjaAsing.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tenaga_kerja_asing);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.judul);
        collapsingToolbarLayout.setTitleEnabled(true);

        tvJudul = findViewById(R.id.tvJudul);
        tvTahun = findViewById(R.id.tvTahun);
        tvTanggal = findViewById(R.id.tvTanggal);
        tvDeskripsi = findViewById(R.id.tvDeskripsi);
        ImageView imgVIew = findViewById(R.id.imgView);


        TenagaKerjaAsingItem TenagaKerjaAsingItem =  getIntent().getParcelableExtra(EXTRA_PLAYER);

        String judul = TenagaKerjaAsingItem.getJudul();
        String tahun = TenagaKerjaAsingItem.getTh_id();
        String tanggal = TenagaKerjaAsingItem.getCreated_at();
        String deskripsi = TenagaKerjaAsingItem.getDeskripsi();

        tvJudul.setText(judul);
        collapsingToolbarLayout.setTitle(judul);
        tvDeskripsi.setText(Html.fromHtml(deskripsi));
        tvTanggal.setText(tanggal);
        tvTahun.setText(tahun);
        Glide.with(this).load("https://buletinnaker.kemnaker.go.id/storage/coverpenta/"+TenagaKerjaAsingItem.getFile()).into(imgVIew);


    }
}
