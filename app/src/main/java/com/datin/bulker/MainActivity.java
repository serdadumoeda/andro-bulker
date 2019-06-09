package com.datin.bulker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void penta(View view){
        Intent intent= new Intent();
        intent.setClass(MainActivity.this, Penta.class);
        startActivity(intent);
    }

    public void lattas(View view){
        Intent intent= new Intent();
        intent.setClass(MainActivity.this, Lattas.class);
        startActivity(intent);
    }
    public void hiwas(View view){
        Intent intent= new Intent();
        intent.setClass(MainActivity.this, Hiwas.class);
        startActivity(intent);
    }
    public void k3(View view){
        Intent intent= new Intent();
        intent.setClass(MainActivity.this, K3.class);
        startActivity(intent);
    }

    public void ku(View view){
        Intent intent= new Intent();
        intent.setClass(MainActivity.this, Ku.class);
        startActivity(intent);
    }
}
