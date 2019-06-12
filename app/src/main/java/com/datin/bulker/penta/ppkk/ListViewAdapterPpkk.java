package com.datin.bulker.penta.ppkk;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.datin.bulker.R;
import com.datin.bulker.penta.p3mi.P3miItem;
import com.datin.bulker.penta.ppkk.PpkkItem;
import com.datin.bulker.penta.ppkk.PpkkItem;

import java.util.List;


public class ListViewAdapterPpkk extends ArrayAdapter<PpkkItem> {

    private List<PpkkItem> PpkkItemList;

    private Context context;

    public ListViewAdapterPpkk(List<PpkkItem> PpkkItemList, Context context) {
        super(context, R.layout.penta_tenaga_kerja_asing_list_item, PpkkItemList);
        this.PpkkItemList = PpkkItemList;
        this.context = context;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.penta_tenaga_kerja_asing_list_item, null, true);

        TextView textViewJudul = listViewItem.findViewById(R.id.textViewJudul);
        TextView textViewTahun = listViewItem.findViewById(R.id.textViewTahun);
        TextView textViewTanggal = listViewItem.findViewById(R.id.textViewTanggal);
        ImageView imgVIew = listViewItem.findViewById(R.id.imgVIew);


        PpkkItem PpkkItem = PpkkItemList.get(position);

        textViewJudul.setText(PpkkItem.getJudul());
        textViewTahun.setText(PpkkItem.getCreated_at());
        textViewTanggal.setText(PpkkItem.getTh_id());
        Glide.with(context).load("https://buletinnaker.kemnaker.go.id/storage/coverpenta/"+PpkkItem.getFile()).into(imgVIew);

        return listViewItem;
    }
}