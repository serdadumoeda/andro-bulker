package com.datin.bulker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.datin.bulker.penta.PentaPasarKerja;
import com.datin.bulker.penta.PentaTenagaKerjaAsing;
import com.datin.bulker.penta.p3mi.PentaP3mi;
import com.datin.bulker.penta.ppkk.PentaPpkk;
import com.datin.bulker.penta.ptkdn.PentaPtkdn;

public class Penta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penta);
    }

    public void pasarKerja(View view){
        Intent intent= new Intent();
        intent.setClass(Penta.this, PentaPasarKerja.class);
        startActivity(intent);
    }

    public void tka(View view){
        Intent intent= new Intent();
        intent.setClass(Penta.this, PentaTenagaKerjaAsing.class);
        startActivity(intent);
    }

    public void p3mi(View view){
        Intent intent= new Intent();
        intent.setClass(Penta.this, PentaP3mi.class);
        startActivity(intent);
    }

    public void ptkdn(View view){
        Intent intent= new Intent();
        intent.setClass(Penta.this, PentaPtkdn.class);
        startActivity(intent);
    }

    public void ppkk(View view){
        Intent intent= new Intent();
        intent.setClass(Penta.this, PentaPpkk.class);
        startActivity(intent);
    }
}
