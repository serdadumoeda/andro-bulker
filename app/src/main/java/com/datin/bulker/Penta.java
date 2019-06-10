package com.datin.bulker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.datin.bulker.penta.PentaPasarKerja;

public class Penta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penta);
    }

    public void penta(View view){
        Intent intent= new Intent();
        intent.setClass(Penta.this, PentaPasarKerja.class);
        startActivity(intent);
    }
}
