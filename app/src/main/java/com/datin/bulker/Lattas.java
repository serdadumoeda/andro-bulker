package com.datin.bulker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.datin.bulker.lattas.bnsp.LattasBnsp;
import com.datin.bulker.lattas.intala.LattasIntala;
import com.datin.bulker.penta.PentaPasarKerja;

public class Lattas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lattas);
    }

    public void bnsp(View view){
        Intent intent= new Intent();
        intent.setClass(Lattas.this, LattasBnsp.class);
        startActivity(intent);
    }

    public void intala(View view){
        Intent intent= new Intent();
        intent.setClass(Lattas.this, LattasIntala.class);
        startActivity(intent);
    }

    public void stankom(View view){
        Intent intent= new Intent();
        intent.setClass(Lattas.this, LattasBnsp.class);
        startActivity(intent);
    }

    public void magang(View view){
        Intent intent= new Intent();
        intent.setClass(Lattas.this, LattasBnsp.class);
        startActivity(intent);
    }

    public void prod(View view){
        Intent intent= new Intent();
        intent.setClass(Lattas.this, LattasBnsp.class);
        startActivity(intent);
    }

    public void lembaga(View view){
        Intent intent= new Intent();
        intent.setClass(Lattas.this, LattasBnsp.class);
        startActivity(intent);
    }
}
