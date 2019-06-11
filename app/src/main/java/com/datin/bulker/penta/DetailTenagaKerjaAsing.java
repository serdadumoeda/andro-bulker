package com.datin.bulker.penta;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import com.datin.bulker.R;
import com.datin.bulker.penta.TenagaKerjaAsingItem;


public class DetailTenagaKerjaAsing extends AppCompatActivity {

    public static String EXTRA_PLAYER = "extra_player";
    TextView tvJudul, tvDeskripsi, tvTahun, tvTanggal;



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


    }
}
