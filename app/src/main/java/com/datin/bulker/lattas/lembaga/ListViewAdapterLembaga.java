package com.datin.bulker.lattas.lembaga;

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
import com.datin.bulker.lattas.lembaga.LembagaItem;

import java.util.List;


public class ListViewAdapterLembaga extends ArrayAdapter<LembagaItem> {

    private List<LembagaItem> LembagaItemList;

    private Context context;

    public ListViewAdapterLembaga(List<LembagaItem> LembagaItemList, Context context) {
        super(context, R.layout.lattas_lembaga_list_item, LembagaItemList);
        this.LembagaItemList = LembagaItemList;
        this.context = context;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.lattas_lembaga_list_item, null, true);

        TextView textViewJudul = listViewItem.findViewById(R.id.textViewJudul);
        TextView textViewTahun = listViewItem.findViewById(R.id.textViewTahun);
        TextView textViewTanggal = listViewItem.findViewById(R.id.textViewTanggal);
        ImageView imgVIew = listViewItem.findViewById(R.id.imgVIew);


        LembagaItem LembagaItem = LembagaItemList.get(position);

        textViewJudul.setText(LembagaItem.getJudul());
        textViewTahun.setText(LembagaItem.getCreated_at());
        textViewTanggal.setText(LembagaItem.getTh_id());
        Glide.with(context).load("https://buletinnaker.kemnaker.go.id/storage/coverlattas/"+LembagaItem.getFile()).into(imgVIew);

        return listViewItem;
    }
}

