package com.datin.bulker;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.datin.bulker.penta.PasarKerjaItem;
import com.github.barteksc.pdfviewer.PDFView;

public class BuletinView extends AppCompatActivity {

    PDFView book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buletin_view);
        book=(PDFView) findViewById(R.id.bulView);
        book.fromUri(Uri.parse("https://buletinnaker.kemnaker.go.id/storage/filepenta/"+ PasarKerjaItem.getCover())).load();
    }
}