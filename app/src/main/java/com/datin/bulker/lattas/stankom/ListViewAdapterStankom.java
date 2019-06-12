package com.datin.bulker.lattas.stankom;

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
import com.datin.bulker.lattas.stankom.StankomItem;

import java.util.List;


public class ListViewAdapterStankom extends ArrayAdapter<StankomItem> {

    private List<StankomItem> StankomItemList;

    private Context context;

    public ListViewAdapterStankom(List<StankomItem> StankomItemList, Context context) {
        super(context, R.layout.lattas_stankom_list_item, StankomItemList);
        this.StankomItemList = StankomItemList;
        this.context = context;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.lattas_stankom_list_item, null, true);

        TextView textViewJudul = listViewItem.findViewById(R.id.textViewJudul);
        TextView textViewTahun = listViewItem.findViewById(R.id.textViewTahun);
        TextView textViewTanggal = listViewItem.findViewById(R.id.textViewTanggal);
        ImageView imgVIew = listViewItem.findViewById(R.id.imgVIew);


        StankomItem StankomItem = StankomItemList.get(position);

        textViewJudul.setText(StankomItem.getJudul());
        textViewTahun.setText(StankomItem.getCreated_at());
        textViewTanggal.setText(StankomItem.getTh_id());
        Glide.with(context).load("https://buletinnaker.kemnaker.go.id/storage/coverlattas/"+StankomItem.getFile()).into(imgVIew);

        return listViewItem;
    }
}


